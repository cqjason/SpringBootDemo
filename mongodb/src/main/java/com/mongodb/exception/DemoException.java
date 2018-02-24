package com.mongodb.exception;

import com.mongodb.enums.ResultEnum;

/**
 * Created by Jason on 2018/1/26.
 */
public class DemoException extends RuntimeException{
    private Integer code;

    public DemoException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

