package springbootapplication.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import springbootapplication.demo.dao.entity.Student;
import springbootapplication.demo.utils.Result;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class HttpAspect {

    @Pointcut(value = "execution(public * springbootapplication.demo.controller.StudentController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("url={}", request.getRequestURL());
        log.info("method={}", request.getMethod());
        log.info("ip={}", request.getRemoteAddr());
        log.info("class method={}", joinPoint.getSignature().getName());
        log.info("class method={}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("args={}", joinPoint.getArgs());
    }

    @AfterReturning(returning = "o", pointcut = "log()")
    public void doAfterReturning(Object o) {
        log.info("response={}", o);
        Result result = (Result) o;
        Student student = (Student) result.getData();
        log.info("student:{}", student);
    }

    @After("log()")
    public void afterMethod() {
        log.info("after method is called");
    }
}
