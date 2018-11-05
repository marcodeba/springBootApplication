package springbootapplication.demo.exception;

import springbootapplication.demo.enums.ResultEnum;

public class StudentException extends Exception {
    private Integer code;

    public StudentException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public StudentException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
