package com.crm.utils;

/**
 *  默认 code：200 msg：操作成功
 */
public class ResultInfo {
    private Integer code = 200;
    private String msg = "操作成功";

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
