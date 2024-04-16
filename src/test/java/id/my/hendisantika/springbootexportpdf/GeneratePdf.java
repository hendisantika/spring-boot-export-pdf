package id.my.hendisantika.springbootexportpdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.junit.jupiter.api.Test;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-export-pdf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/16/24
 * Time: 09:00
 * To change this template use File | Settings | File Templates.
 */
public class GeneratePdf {
    @Test
    public void addPDF() {
        // Define the path for the output PDF file
        String outputPath = System.getProperty("user.dir") + "/output/first.pdf";

        try {
            // Create a PdfWriter instance and specify the output file path
            PdfWriter writer = new PdfWriter(outputPath);

            // Initialize a PdfDocument using PdfWriter
            PdfDocument pdf = new PdfDocument(writer);

            // Initialize a Document using the PdfDocument
            Document document = new Document(pdf);

            // Add a simple paragraph to the Document
            document.add(new Paragraph("Text content..."));

            // Close the Document to complete the PDF writing
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}