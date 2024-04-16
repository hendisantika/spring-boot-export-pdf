package id.my.hendisantika.springbootexportpdf.controller;

import id.my.hendisantika.springbootexportpdf.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

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
}
