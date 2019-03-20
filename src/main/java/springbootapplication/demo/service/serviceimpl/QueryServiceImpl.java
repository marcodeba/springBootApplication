package springbootapplication.demo.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootapplication.demo.dao.StudentRespoitory;
import springbootapplication.demo.dao.entity.Student;
import springbootapplication.demo.exception.StudentException;
import springbootapplication.demo.service.IQueryService;
import springbootapplication.demo.enums.ResultEnum;

import java.util.List;

@Service
public class QueryServiceImpl implements IQueryService {

    @Autowired
    StudentRespoitory studentRespoitory;

    @Override
    public List<Student> getStudentList() {
        return studentRespoitory.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRespoitory.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        System.out.println("getStudentById:" + id);
        return studentRespoitory.findById(id).get();
    }

    public List<Student> getStudentsByAge(Integer age) {
        return studentRespoitory.getStudentsByAge(age);
    }

    @Override
    public void getStudentAge(Integer id) throws Exception {
        Student student = studentRespoitory.findById(id).get();
        if (student.getAge() > 100) {
            throw new StudentException(ResultEnum.RESULTISINVALID);
        }
    }
}
