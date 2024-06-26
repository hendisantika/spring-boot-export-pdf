package id.my.hendisantika.springbootexportpdf;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
    public static final String HTML = "<h1>Hello</h1>"
            + "<p>This was created using iText</p>"
            + "<a href='https://s.id/hendisantika'>Hendi Santika</a>";

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

    @Test
    public void EditPDF() {
        // Define the paths for the source PDF file and the output PDF file
        String inputPath = System.getProperty("user.dir") + "/files/original.pdf";
        String outputPath = System.getProperty("user.dir") + "/files/editing.pdf";

        try {
            // Create PdfReader and PdfWriter instances, specifying input and output file paths
            PdfDocument pdfDoc = new PdfDocument(new PdfReader(inputPath), new PdfWriter(outputPath));

            // Initialize a Document using the PdfDocument
            Document document = new Document(pdfDoc);

            // Add a new paragraph to the first page of the Document
            document.add(new Paragraph("New paragraph content...").setFixedPosition(100, 700, 400));

            // Close the Document to complete the PDF writing
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void HTMLToPDF() {
        // Define the source of html file and output file
        String inputPath = System.getProperty("user.dir") + "/files/source.html";
        String outputPath = System.getProperty("user.dir") + "/files/converted.pdf";

        try {
            // Converting file from html to pdf
            HtmlConverter.convertToPdf(new FileInputStream(inputPath), new FileOutputStream(outputPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void HTMLToPDF2() throws IOException {
        String inputPath = System.getProperty("user.dir") + "/files/source2.html";
        String outputPath = System.getProperty("user.dir") + "/files/converted2.pdf";

        try {
            // Converting file from html to pdf
            HtmlConverter.convertToPdf(HTML, new FileOutputStream("string-to-pdf.pdf"));
//            HtmlConverter.convertToPdf(new FileInputStream(inputPath), new FileOutputStream(outputPath));
            System.out.println("PDF Created!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
