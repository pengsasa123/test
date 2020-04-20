
package com.example.test.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;

/**
 * 响应数据
 *
 * @author huangyf
 */
public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public Result() {
//        put("traceId", MDC.get("traceId")); // 暂时不用traceId
        put("code", StatusCodeEnum.OK.getCode());
        put("msg", "success");
        put("data", Maps.newHashMap());
    }

    /**
     * 功能：判断请求是否成功 详细：
     *
     * @return 成功返回true
     */
    @JsonIgnore
    public boolean isSuccess() {
        return (int) get("code") == StatusCodeEnum.OK.getCode();
    }

    public static Result failure() {
        return failure(StatusCodeEnum.INTERNAL_SERVER_ERROR.getCode(), "由于系统维护，请稍后再试");
    }

    public static Result failure(String msg) {
        return failure(StatusCodeEnum.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    public static Result failure(StatusCodeEnum status) {
        return failure(status.getCode(), status.getName());
    }

    public static Result failure(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", null);
        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result success() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 设置data数据
     */
    public <T> Result setData(T data) {
        this.put("data", data);
        return this;
    }

    /**
     * 获取data数据
     */
    public <T> T getData(Class<T> clazz) {
        return (T) this.get("data");
    }

    /**
     * data加数据
     */
    public Result putData(String key, Object value) {
        ((HashMap) super.get("data")).put(key, value);
        return this;
    }

    /**
     * data加list
     */
    public <T> Result addData(List<T> list) {
        this.putData("list", list);
        return this;
    }

    /**
     * data加单个对象数据
     */
    public <T> Result addData(T info) {
        this.putData("info", info);
        return this;
    }
}
