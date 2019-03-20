package springbootapplication.demo.service.serviceimpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springbootapplication.demo.dao.entity.Student;
import springbootapplication.demo.service.IQueryService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryServiceImplTest {
    @Autowired
    private IQueryService queryService;

    @Test
    public void getStudentById() throws Exception {
        Student student = queryService.getStudentById(5);
        Assert.assertEquals(new Integer(1), student.getAge());
    }

    @Test
    public void testCache() throws Exception {
        queryService.getStudentById(5);
        queryService.getStudentById(5);
        queryService.getStudentById(5);
    }
}