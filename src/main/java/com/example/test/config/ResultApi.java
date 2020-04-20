package com.example.test.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Optional;

/**
 * 统一API响应结果封装
 *
 * @author Chill
 */
@Getter
@Setter
@ToString
//@ApiModel(description = "返回信息")
@NoArgsConstructor
public class ResultApi<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    //@ApiModelProperty(value = "状态码", required = true)
    private int code;
    //@ApiModelProperty(value = "是否成功", required = true)
    private boolean success;
    //@ApiModelProperty(value = "承载数据")
    private T data;
    //@ApiModelProperty(value = "返回消息", required = true)
    private String msg;

    private ResultApi(StatusCodeEnum resultCode) {
        this(resultCode, null, resultCode.getName());
    }

    private ResultApi(StatusCodeEnum resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private ResultApi(StatusCodeEnum resultCode, T data) {
        this(resultCode, data, resultCode.getName());
    }

    private ResultApi(StatusCodeEnum resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private ResultApi(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = StatusCodeEnum.OK.getCode() == code;
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isSuccess(@Nullable ResultApi<?> result) {
        return Optional.ofNullable(result)
            .map(x -> ObjectUtils.nullSafeEquals(StatusCodeEnum.OK.getCode(), x.code))
            .orElse(Boolean.FALSE);
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isNotSuccess(@Nullable ResultApi<?> result) {
        return !ResultApi.isSuccess(result);
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> ResultApi<T> data(T data) {
        return data(data, "success");
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> ResultApi<T> data(T data, String msg) {
        return data(StatusCodeEnum.OK.getCode(), data, msg);
    }

    /**
     * 返回R
     *
     * @param code 状态码
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> ResultApi<T> data(int code, T data, String msg) {
        return new ResultApi<>(code, data, data == null ? "success" : msg);
    }

    /**
     * 返回R
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> ResultApi<T> success(String msg) {
        return new ResultApi<>(StatusCodeEnum.OK, msg);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> ResultApi<T> success(StatusCodeEnum resultCode) {
        return new ResultApi<>(resultCode);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> ResultApi<T> success(StatusCodeEnum resultCode, String msg) {
        return new ResultApi<>(resultCode, msg);
    }

    /**
     * 返回R
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> ResultApi<T> failure(String msg) {
        return new ResultApi<>(StatusCodeEnum.INTERNAL_SERVER_ERROR, msg);
    }


    /**
     * 返回R
     *
     * @param code 状态码
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> ResultApi<T> failure(int code, String msg) {
        return new ResultApi<>(code, null, msg);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> ResultApi<T> failure(StatusCodeEnum resultCode) {
        return new ResultApi<>(resultCode);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> ResultApi<T> failure(StatusCodeEnum resultCode, String msg) {
        return new ResultApi<>(resultCode, msg);
    }

    /**
     * 返回R
     *
     * @param flag 成功状态
     * @return R
     */
    public static <T> ResultApi<T> status(boolean flag) {
        return flag ? success(StatusCodeEnum.OK) : failure(StatusCodeEnum.INTERNAL_SERVER_ERROR);
    }

}
