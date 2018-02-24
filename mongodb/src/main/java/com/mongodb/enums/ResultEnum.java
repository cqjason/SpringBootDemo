package com.mongodb.enums;

/**
 * Created by Jason on 2018/1/26.
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1,"UNKNOWN ERROR"),
    SUCCESS(0,"SUCCESSFUL"),
    BOY(100,"You are a boy"),
    MAN(101,"You are a man")
    ;
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
