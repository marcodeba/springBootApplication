package springbootapplication.demo.service;

import springbootapplication.demo.dao.entity.Student;

import java.util.List;

public interface IQueryService {
    List<Student> getStudentList();

    Student addStudent(Student student);

    Student getStudentById(Integer id) throws Exception;

    List<Student> getStudentsByAge(Integer age);

    void getStudentAge(Integer id) throws Exception;
}
