package springbootapplication.demo.utils;

import springbootapplication.demo.domain.Result;

public class ResultUtil {
    public static Result success(Object obj) {
        Result result = new Result();
        result.setResultCode(200);
        result.setResultMsg("success");
        result.setData(obj);

        return result;
    }

    public static Result error(Integer errCode, String errMsg) {
        Result result = new Result();
        result.setResultCode(errCode);
        result.setResultMsg(errMsg);

        return result;
    }
}
