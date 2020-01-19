package com.holiday.util;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

/**
 * @author Elvis
 * @DESCRIPTION 统一API响应结果封装
 */
@Component("restResult")
public class RestResult {
    private int code;//状态码

    private String message;//消息

    private Object data;//数据

    public void setCode(int code) {
        this.code = code;
    }
    public RestResult setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public RestResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestResult setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
