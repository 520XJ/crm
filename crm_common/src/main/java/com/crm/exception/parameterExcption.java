package com.crm.exception;

/**
 *  自定义异常
 */
public class parameterExcption extends RuntimeException{

    private static final long serialVersionUID = -4258386027486892346L;
    private Integer code;

    private String msg;

    public parameterExcption(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
