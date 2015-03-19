package nominas.control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFController {
    private final String filename;
    public static final int RECIBO_DE_NOMINA = 0;
    public static final int LISTA_DE_RAYA = 1;

    public PDFController(String filename) {
        this.filename = filename;
    }
    
    public void createPdf(int type)
        throws IOException, DocumentException {
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        if(type == RECIBO_DE_NOMINA)
            document.add(generateReciboNominas());
        else if(type == LISTA_DE_RAYA)
            document.add(generateListaRaya());
        // step 5
        document.close();
    }
    
    public PdfPTable generateReciboNominas() {
        Phrase heading = new Phrase("H.Ayuntamiento de Villanueva 2013 - 2016 \nPlaza Principal Num 1, Villanueva, Zacatecas \nR.F.C.: MVI650101HF1   Reg. IMSS: R091008010");
        Phrase personalData = new Phrase("");
        Phrase footer = new Phrase("");
        
        PdfPTable table = new PdfPTable(2);
        
        PdfPCell cell = new PdfPCell(heading);
        cell.setNoWrap(false);        
        cell.setColspan(2);                
        table.addCell(cell);
        
        cell.setPhrase(personalData);
        table.addCell(cell);
        
        table.addCell("PERCEPCIONES");
        table.addCell("DEDUCCIONES");
        
        table.addCell("Sueldo y otras percepciones");
        table.addCell("Deducciones");
        
        table.addCell("Suma de percepciones");
        table.addCell("Suma de Deducciones");
        
        table.addCell(" ");
        table.addCell(" ");
        
        cell.setPhrase(footer);
        table.addCell(cell);
        
        return table;
    }
    
    public PdfPTable generateListaRaya() {
        return null;
    }
    
    public PdfPTable createTestTable() {
    	// a table with three columns
        PdfPTable table = new PdfPTable(3);
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("Cell with colspan 3"));
        cell.setColspan(3);
        table.addCell(cell);
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        // we add the four remaining cells with addCell()
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        return table;
    }
}
