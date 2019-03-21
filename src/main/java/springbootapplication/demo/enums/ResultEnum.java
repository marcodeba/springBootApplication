package springbootapplication.demo.enums;

public enum ResultEnum {
    UNKNOWN_ERROR(-100, "未知错误"),
    SUCCESS(200, "成功"),
    NoDataFound(0, "未发现Student"),
    RESULTISINVALID(300, "are you sure you can live longer than 100???");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
