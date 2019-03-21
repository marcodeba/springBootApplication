package springbootapplication.demo.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootapplication.demo.dao.StudentRespoitory;
import springbootapplication.demo.dao.entity.Student;
import springbootapplication.demo.enums.ResultEnum;
import springbootapplication.demo.exception.StudentException;
import springbootapplication.demo.service.IQueryService;

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
    public Student getStudentById(Integer id) throws Exception {
        System.out.println("getStudentById:" + id);
        if (studentRespoitory.findById(id).isPresent())
            return studentRespoitory.findById(id).get();
        else {
            throw new StudentException(ResultEnum.NoDataFound);
        }
    }

    public List<Student> getStudentsByAge(Integer age) {
        return studentRespoitory.getStudentsByAge(age);
    }

    @Override
    public void getStudentAge(Integer id) {
        Student student = studentRespoitory.findById(id).get();
        if (student.getAge() > 100) {
            throw new StudentException(ResultEnum.RESULTISINVALID);
        }
    }

    @Override
    public void delStudentById(Integer id) {
        studentRespoitory.deleteById(id);
    }
}
