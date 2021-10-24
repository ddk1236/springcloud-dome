package com.ie.common;

import lombok.Data;

/**
 * @author ddk
 * @date 2021/10/22
 */
@Data
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    public static Result success() {
        Result result = new Result<>();
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    public static Result failed() {
        Result result = new Result<>();
        result.setCode(500);
        result.setMsg("操作失败");
        return result;
    }

    public static Result back(Boolean b) {
        return b ? success() : failed();
    }

    public static <T> Result<T> back(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> back(String msg,T data){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
