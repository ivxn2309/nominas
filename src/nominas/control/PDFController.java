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
import java.util.Calendar;
import java.util.List;
import nominas.entity.Empleado;
import nominas.util.Fecha;
import nominas.util.ReciboDeNomina;

public class PDFController {

    private final String filename;
    public static final int RECIBO_DE_NOMINA = 0;
    public static final int LISTA_DE_RAYA = 1;

    public PDFController(String filename) {
        this.filename = filename;
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
            for(Empleado emp : empleados) {
                document.add(generateReciboNominas(emp, today));
                if(i % 2 == 0) document.newPage();
                i++;
            }
        } 
        else if (type == LISTA_DE_RAYA) {
            int i = 1;
            for(Empleado emp : empleados) {
                document.add(generateListaRaya(emp, today));
                if(i % 2 == 0) document.newPage();
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
        
        PdfPTable table = new PdfPTable(2);
        table.setSpacingAfter(20f);
        Phrase head = new Phrase(recibo.getHead(), font);
        PdfPCell cell = new PdfPCell(head);
        cell.setNoWrap(false);
        cell.setColspan(2);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
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

        table.addCell(new Phrase("Suma de Percepciones: $ " + recibo.getSumaPer(), font));
        table.addCell(new Phrase("Suma de Deducciones: $ " + recibo.getSumaDed(), font));

        cell = new PdfPCell(new Phrase("Neto:   $ " + recibo.getNeto(), font));
        cell.setNoWrap(false);
        cell.setColspan(2);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase(recibo.getFooter(), font));
        cell.setNoWrap(false);
        cell.setColspan(2);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase(recibo.getIsr(), font));
        cell.setNoWrap(false);
        cell.setColspan(2);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);
        return table;
    }

    public PdfPTable generateListaRaya(Empleado emp, Fecha fecha) {
        return null;
    }
}
