package nominas.control;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import nominas.entity.Deduccion;
import nominas.entity.Empleado;
import nominas.entity.Institucion;
import nominas.entity.ListaNomina;
import nominas.entity.Percepcion;
import nominas.util.Fecha;
import nominas.util.ListaDeRaya;
import nominas.util.ReciboDeNomina;

public class PDFController {

    private final String filename;
    public static final int RECIBO_DE_NOMINA = 0;
    public static final int LISTA_DE_RAYA = 1;
    public Institucion institucion;

    public PDFController(String filename) {
        this.filename = filename;
        institucion = new InstitucionController().get();
    }

    public void createPdf(int type)
            throws IOException, DocumentException, FileNotFoundException {

        //Esta linea se cambiara cuando se vaya a incluir otras fechas
        List<Empleado> empleados = new EmpleadoController().getAllActualEmpleados();
        Fecha today = new Fecha(Calendar.getInstance().getTime());

        // step 1
        Document document = new Document();
        document.setMargins(20.0f, 20.0f, 40.0f, 20.0f);
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        if (type == RECIBO_DE_NOMINA) {
            int i = 1;
            for (Empleado emp : empleados) {
                document.add(generateReciboNominas(emp, today));
                if (i % 2 == 0) {
                    document.newPage();
                }
                i++;
            }
        }
        // step 5
        document.close();
    }

    public void createPdf(int type, ListaNomina nomina)
            throws IOException, DocumentException, FileNotFoundException {

        List<Empleado> allEmpleados = new EmpleadoController().getAllActualEmpleados();
        List<Empleado> empleados = new ArrayList<>();

        allEmpleados.stream()
                .filter((emp) -> (emp.getNomina() == nomina.getId()))
                .forEach((emp) -> {
                    empleados.add(emp);
                });

        Fecha today = new Fecha(Calendar.getInstance().getTime());

        // step 1
        Document document = new Document();
        document.setMargins(20.0f, 20.0f, 40.0f, 20.0f);
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        if (type == RECIBO_DE_NOMINA) {
            int i = 1;
            for (Empleado emp : empleados) {
                document.add(generateReciboNominas(emp, today));
                if (i % 2 == 0) {
                    document.newPage();
                }
                i++;
            }
        } else if (type == LISTA_DE_RAYA) {
            document.add(generateHeaderListaRaya(today));
            int i = 1;
            for (Empleado emp : empleados) {
                document.add(generateListaRaya(emp, today));
                if (i % 5 == 0 && i < empleados.size()) {
                    document.newPage();
                }
                i++;
            }
        }
        // step 5
        document.close();
    }

    public void createPdf(int type, List<Empleado> empleados)
            throws IOException, DocumentException, FileNotFoundException {

        //Esta linea se cambiara cuando se vaya a incluir otras fechas
        Fecha today = new Fecha(Calendar.getInstance().getTime());

        // step 1
        Document document = new Document();
        document.setMargins(20.0f, 20.0f, 40.0f, 20.0f);
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        if (type == RECIBO_DE_NOMINA) {
            int i = 1;
            for (Empleado emp : empleados) {
                document.add(generateReciboNominas(emp, today));
                if (i % 2 == 0) {
                    document.newPage();
                }
                i++;
            }
        }
        // step 5
        document.close();
    }

    private PdfPTable generateReciboNominas(Empleado emp, Fecha fecha) throws IOException, DocumentException {
        ReciboDeNomina recibo = new ReciboDeNomina(emp, fecha);
        BaseFont bf = BaseFont.createFont(BaseFont.COURIER, BaseFont.WINANSI, BaseFont.EMBEDDED);
        Font font = new Font(bf, 8);
        Font font2 = new Font(bf, 8, Font.BOLD);

        PdfPTable table = new PdfPTable(2);
        table.setSpacingAfter(20f);
        Phrase head = new Phrase(recibo.getHead(), font2);
        PdfPCell cell = new PdfPCell(head);
        cell.setNoWrap(false);
        cell.setColspan(2);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        table.addCell(cell);
        cell.setPhrase(new Phrase(recibo.getPeriod(), font));
        table.addCell(cell);

        PdfPCell data1Cell = new PdfPCell(new Phrase(recibo.getData1(), font));
        PdfPCell data2Cell = new PdfPCell(new Phrase(recibo.getData2(), font));
        data2Cell.setBorder(Rectangle.RIGHT);
        data2Cell.setBorderColorRight(BaseColor.WHITE);
        data1Cell.setBorder(Rectangle.LEFT);
        data1Cell.setBorderColorLeft(BaseColor.WHITE);
        table.addCell(data1Cell);
        table.addCell(data2Cell);

        table.addCell(new Phrase("Percepciones", font));
        table.addCell(new Phrase("Deducciones", font));

        PdfPCell perc = new PdfPCell(new Phrase(recibo.getPercepciones(), font));
        PdfPCell ded = new PdfPCell(new Phrase(recibo.getDeducciones(), font));
        perc.setFixedHeight(150);
        ded.setFixedHeight(150);
        table.addCell(perc);
        table.addCell(ded);

        table.addCell(new Phrase("Suma de Percepciones: $ " + recibo.getSumaPer(), font2));
        table.addCell(new Phrase("Suma de Deducciones: $ " + recibo.getSumaDed(), font2));

        cell = new PdfPCell(new Phrase("Neto:   $ " + recibo.getNeto(), font2));
        cell.setNoWrap(false);
        cell.setColspan(2);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(recibo.getFooter(), font));
        cell.setNoWrap(false);
        cell.setColspan(2);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
        table.addCell(cell);

        return table;
    }

    public PdfPTable generateListaRaya(Empleado emp, Fecha fecha) throws IOException, DocumentException{
        ListaDeRaya raya = new ListaDeRaya(emp, fecha);
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
        Font font = new Font(bf, 8);
        Font font2 = new Font(bf, 9, Font.BOLD);
        Font font3 = new Font(bf, 7, Font.BOLD);

        PdfPTable table = new PdfPTable(6);
        table.setSpacingAfter(20f);
        
        PdfPCell cell = new PdfPCell();
        cell.setNoWrap(false);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.TOP);
        cell.setBorder(Rectangle.BOTTOM);
        
        cell.setPhrase(new Phrase("Percepcion", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Valor", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Importe", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Deduccion", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Valor", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Importe", font));
        table.addCell(cell);
        
        cell = new PdfPCell();
        cell.setBorderColor(BaseColor.WHITE);
        cell.setBorder(Rectangle.BOTTOM);
        cell.setColspan(6);
        cell.setNoWrap(false);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cell.setPhrase(new Phrase("   " + raya.getEmpleado().getId_empleado() + "  " +
                raya.getEmpleado().toString(), font2));
        table.addCell(cell);
        cell.setColspan(3);
        cell.setBorderColor(BaseColor.BLACK);
        cell.setBorder(Rectangle.BOTTOM);
        cell.setPhrase(new Phrase(raya.getData1(), font3));
        table.addCell(cell);
        cell.setPhrase(new Phrase(raya.getData2(), font3));
        table.addCell(cell);
        
        cell = new PdfPCell();
        cell.setNoWrap(false);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cell.setBorderColor(BaseColor.WHITE);
        cell.setBorder(Rectangle.BOTTOM);
        
        int init = 0;
        List<Percepcion> percs = raya.getPercepciones();
        List<Deduccion> dedus = raya.getDeducciones();
        int max = percs.size() > dedus.size() ? percs.size() : dedus.size();
        for(int i = 0; i < max; i++) {
            cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            if(i < percs.size()) { //Si faltan percepciones
                cell.setPhrase(new Phrase(percs.get(i).getNombre(), font));
                table.addCell(cell);
                cell.setPhrase(new Phrase(" ", font));
                if(init == 0) { //Al sueldo le agregamos valor
                    cell.setPhrase(new Phrase("" + raya.getEmpleado().getDias_jornada(), font));
                    init++;
                }
                cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table.addCell(cell);
                cell.setPhrase(new Phrase(""+percs.get(i).getCantidad(), font));
                table.addCell(cell);
            }
            else {// Si no quedan mas percepciones
                cell.setPhrase(new Phrase(" ", font));
                table.addCell(cell);
                table.addCell(cell);
                table.addCell(cell);
            }
            cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            if(i < dedus.size()) { //Si faltan deducciones
                cell.setPhrase(new Phrase(dedus.get(i).getNombre(), font));
                table.addCell(cell);
                cell.setPhrase(new Phrase(" ", font));
                table.addCell(cell);
                cell.setPhrase(new Phrase(""+dedus.get(i).getCantidad(), font));
                cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table.addCell(cell);
            }
            else {// Si no quedan mas deducciones
                cell.setPhrase(new Phrase(" ", font));
                table.addCell(cell);
                table.addCell(cell);
                table.addCell(cell);
            }
        }//Aqui termina la seccion de deducciones y percepciones
        //Una linea
        cell = new PdfPCell();
        cell.setColspan(6);
        cell.setBorder(Rectangle.BOTTOM);
        cell.setFixedHeight(1);
        table.addCell(cell);
        //Siguiente seccion
        cell = new PdfPCell();
        cell.setBorderColor(BaseColor.WHITE);
        cell.setBorder(Rectangle.TOP);
        cell.setBorder(Rectangle.BOTTOM);
        cell.setNoWrap(false);
        cell.setHorizontalAlignment(PdfPCell.LEFT);
        //Se agregan los totales de percepciones
        Percepcion p = raya.getTotalPercepciones();
        Deduccion d = raya.getTotalDeducciones();
        cell.setPhrase(new Phrase(p.getNombre(), font));
        table.addCell(cell);
        cell.setPhrase(new Phrase(" ", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase(""+p.getCantidad(), font));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        table.addCell(cell);
        //Se agregan los totales de deducciones
        cell.setPhrase(new Phrase(d.getNombre(), font));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        table.addCell(cell);
        cell.setPhrase(new Phrase(" ", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase(""+d.getCantidad(), font));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        table.addCell(cell);
        // Se agrega el neto
        cell.setPhrase(new Phrase("Neto a Pagar", font2));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        table.addCell(cell);
        cell.setPhrase(new Phrase(" ", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase(""+raya.getNeto(), font2));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        table.addCell(cell);
        //Neto deducciones en blanco
        cell.setColspan(3);
        cell.setPhrase(new Phrase(" ", font));
        table.addCell(cell);
        //Una linea en blanco al final
        cell.setColspan(6);
        cell.setPhrase(new Phrase(" ", font));
        table.addCell(cell);
        //Se regresa la tabla terminada
        return table;
    }
    
    public PdfPTable generateHeaderListaRaya(Fecha fecha) throws IOException, DocumentException{
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
        
        Font font = new Font(bf, 8, Font.BOLD);
        Font font2 = new Font(bf, 9);
        Font font3 = new Font(bf, 8);

        PdfPTable table = new PdfPTable(3);
        table.setSpacingAfter(20f);
        
        PdfPCell cell = new PdfPCell();
        cell.setNoWrap(false);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBorder(Rectangle.BOTTOM);
        
        StringBuilder str = new StringBuilder();        
        str.append("Reg. Pat. IMSS: ").append(institucion.getImss()).append("\n");
        str.append("R.F.C.: ").append(institucion.getRfc()).append("\n");
        cell.setPhrase(new Phrase(str.toString(), font3));
        table.addCell(cell);
        
        Fecha [] quince = fecha.getPeriodInterval();
        str = new StringBuilder();
        str.append(institucion.getName()).append("\n\n");
        str.append("Lista de Raya del ").append(quince[0].getShortRepr("/", false)).append(" al ")
                .append(quince[1].getShortRepr("/", false)).append("\n");
        str.append("Periodo Quincenal No. ").append(fecha.getFortnightYear()).append("\n");
        str.append(institucion.getAddress());
        cell.setPhrase(new Phrase(str.toString(), font));
        table.addCell(cell);
        
        str = new StringBuilder();
        str.append("Este archivo fue generado el: ").append(fecha.getShortRepr("/", false)).append("\n");
        str.append("Usando: ").append("**Sistema de Nominas**").append("\n");
        cell.setPhrase(new Phrase(str.toString(), font3));
        table.addCell(cell);
        return table;
    }
}
