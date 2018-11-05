package springbootapplication.demo.exceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springbootapplication.demo.domain.Result;
import springbootapplication.demo.exception.StudentException;
import springbootapplication.demo.utils.ResultUtil;

@ControllerAdvice
public class StudentExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(StudentExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e) {
        if (e instanceof StudentException) {
            StudentException se = (StudentException) e;
            return ResultUtil.error(se.getCode(), se.getMessage());
        }
        // 系统异常
        logger.error("【系统异常】{}" + e);
        return ResultUtil.error(-200, "UNKNOWN ERROR");
    }
}
