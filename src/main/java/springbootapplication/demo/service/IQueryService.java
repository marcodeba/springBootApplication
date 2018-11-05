package springbootapplication.demo.service;

import springbootapplication.demo.dao.entity.Student;

import java.util.List;

public interface IQueryService {
    public List<Student> getStudentList();

    public Student addStudent(Student student);

    public Student getStudentById(Integer id) throws Exception;

    public List<Student> getStudentsByAge(Integer age);

    public void getStudentAge(Integer id) throws Exception;
}
