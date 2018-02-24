package com.mongodb.utils;

import com.mongodb.domain.Result;

/**
 * Created by Jason on 2018/1/26.
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("successful");
        result.setData(object);
        return result;
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
