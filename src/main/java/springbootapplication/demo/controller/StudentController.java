package springbootapplication.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springbootapplication.demo.dao.entity.Student;
import springbootapplication.demo.domain.Result;
import springbootapplication.demo.service.IQueryService;
import springbootapplication.demo.utils.ResultUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    IQueryService queryService;

    @GetMapping(value = "/students")
    @ResponseBody
    public Result<List<Student>> getStudentList() {
        return ResultUtil.success(queryService.getStudentList());
    }

    @PostMapping(value = "/addStudent")
    @ResponseBody
    public Result<Student> addStudent(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errMsg = bindingResult.getFieldError().getDefaultMessage();
            return ResultUtil.error(-100, errMsg);
        } else {
            return ResultUtil.success(queryService.addStudent(student));
        }
    }

    @GetMapping(value = "/getStudentById/{stuId}")
    @ResponseBody
    public Result<Student> getStudentById(@PathVariable("stuId") Integer stuId) throws Exception{
        try {
            return ResultUtil.success(queryService.getStudentById(stuId));
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping(value = "/getStudentsByAge/{age}")
    @ResponseBody
    public Result<List<Student>> getStudentList(@PathVariable("age") Integer age) {
        return ResultUtil.success(queryService.getStudentsByAge(age));
    }

    @GetMapping(value = "/getAgeById/{id}")
    @ResponseBody
    public void getStudentAge(@PathVariable("id") Integer id) throws Exception {
        queryService.getStudentAge(id);
    }
}
