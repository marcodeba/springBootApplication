package springbootapplication.demo.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class CallResult<T extends Serializable> implements Serializable {
    private T model;
    private boolean success = true;
    private int errorCode;
    private String errorMsg;

    public CallResult() {
    }

    public CallResult(int code, String msg) {
        this.success = false;
        this.errorCode = code;
        this.errorMsg = msg;
    }

    public CallResult(T model) {
        this.model = model;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
