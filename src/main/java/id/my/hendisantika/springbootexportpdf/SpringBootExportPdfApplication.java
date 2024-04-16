package id.my.hendisantika.springbootexportpdf;

import id.my.hendisantika.springbootexportpdf.entity.Student;
import id.my.hendisantika.springbootexportpdf.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootExportPdfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExportPdfApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(StudentService studentService) {
        return args -> {
            for (int i = 0; i <= 10; i++) {
                Student student = new Student();
                student.setStudentName("Student Name " + i);
                student.setEmail("student" + i + "@yopmail.com");
                student.setMobileNo("+62813214118" + i);
                studentService.addStudent(student);
            }
        };
    }
}
