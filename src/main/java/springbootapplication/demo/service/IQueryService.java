package springbootapplication.demo.service;

import org.springframework.cache.annotation.Cacheable;
import springbootapplication.demo.dao.entity.Student;

import java.util.List;

public interface IQueryService {
    List<Student> getStudentList();

    Student addStudent(Student student);

    @Cacheable(value = "student", key = "'student'+#id")
    Student getStudentById(Integer id) throws Exception;

    List<Student> getStudentsByAge(Integer age);

    void getStudentAge(Integer id) throws Exception;

    void delStudentById(Integer id);
}
