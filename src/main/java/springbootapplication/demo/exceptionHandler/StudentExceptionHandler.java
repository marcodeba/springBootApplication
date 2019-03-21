package springbootapplication.demo.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springbootapplication.demo.domain.Result;
import springbootapplication.demo.exception.StudentException;
import springbootapplication.demo.utils.ResultUtil;

@ControllerAdvice
@Slf4j
public class StudentExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e) {
        if (e instanceof StudentException) {
            StudentException se = (StudentException) e;
            return ResultUtil.error(se.getCode(), se.getMessage());
        }
        // 系统异常
        log.error("【系统异常】{}" + e);
        return ResultUtil.error(-200, "UNKNOWN ERROR");
    }
}
