package id.my.hendisantika.springbootexportpdf.controller;

import com.lowagie.text.DocumentException;
import id.my.hendisantika.springbootexportpdf.entity.Student;
import id.my.hendisantika.springbootexportpdf.service.StudentService;
import id.my.hendisantika.springbootexportpdf.util.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-export-pdf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/16/24
 * Time: 08:35
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/export-to-pdf")
    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=students" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);
        List<Student> listofStudents = studentService.getStudentList();
        PdfGenerator generator = new PdfGenerator();
        generator.generate(listofStudents, response);
    }
}
