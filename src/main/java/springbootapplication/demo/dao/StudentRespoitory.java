package springbootapplication.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapplication.demo.dao.entity.Student;

import java.util.List;

public interface StudentRespoitory extends JpaRepository<Student, Integer> {
    List<Student> getStudentsByAge(Integer age);
}
