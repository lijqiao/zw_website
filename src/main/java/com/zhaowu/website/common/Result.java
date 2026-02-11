package com.zhaowu.website.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * 接口返回数据格式
 *
 * @author scott
 * @email jeecgos@163.com
 * @date 2019年1月19日
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;
    /**
     * 返回处理消息
     */
    private String message = "SUCCESS";
    /**
     * 返回代码
     */
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    private T result;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public Result() {
    }

    /**
     * 兼容VUE3版token失效不跳转登录页面
     *
     * @param code
     * @param message
     */
    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result<T> success(String message) {
        this.message = message;
        this.code = ResponseConstant.SUCCESS;
        this.success = true;
        return this;
    }

    public static <T> Result<T> ok() {
        return ok("SUCCESS");
    }

    public static <T> Result<T> ok(String msg) {
        Result<T> r = new Result<T>();
        r.success = true;
        r.code = ResponseConstant.SUCCESS;
        r.result = (T) msg;
        r.message = msg;
        return r;
    }

    public static <T> Result<T> ok(T data, String msg) {
        Result<T> r = new Result<T>();
        r.success = true;
        r.code = ResponseConstant.SUCCESS;
        r.result = data;
        r.message = msg;
        return r;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> r = new Result<T>();
        r.success = true;
        r.code = ResponseConstant.SUCCESS;
        r.result = data;
        return r;
    }

    public static <T> Result<T> error(String msg, T data) {
        Result<T> r = new Result<T>();
        r.success = false;
        r.code = ResponseConstant.FAIL;
        r.result = data;
        r.message = msg;
        return r;
    }

    public static <T> Result<T> error(String msg) {
        return error(ResponseConstant.FAIL, msg);
    }

    public static <T> Result<T> error(int code, String msg) {
        Result<T> r = new Result<T>();
        r.success = false;
        r.code = code;
        r.message = msg;
        return r;

    }

}

