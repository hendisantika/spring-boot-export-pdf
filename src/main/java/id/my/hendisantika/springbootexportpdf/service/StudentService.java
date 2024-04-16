package id.my.hendisantika.springbootexportpdf.service;

import id.my.hendisantika.springbootexportpdf.entity.Student;
import id.my.hendisantika.springbootexportpdf.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-export-pdf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/16/24
 * Time: 08:32
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(Student student) {
        log.info("Add new student data ... ");
        studentRepository.save(student);
    }

    public List<Student> getStudentList() {
        log.info("List all students data ... ");
        return studentRepository.findAll();
    }
}
