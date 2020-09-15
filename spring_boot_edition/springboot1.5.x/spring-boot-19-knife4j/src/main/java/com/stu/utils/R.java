package com.stu.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/26
 * @To change this template use File | Settings | File Templates.
 * @desc: 信息数据返回model
 */
@ApiModel("数据返回封装model")
public class R<T> implements Serializable {

    @ApiModelProperty("状态码")
    private Integer code;                   //  状态码
    @ApiModelProperty("提示信息")
    private String msg;                     //  提示信息
    @ApiModelProperty("数据信息")
    private T data;                         // 数据信息

    private R(EResultCode resultCode) {
        this(resultCode, null, resultCode.getMessage());
    }

    private R(EResultCode resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private R(EResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    private R(EResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private R(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    // 成功
    public static <T> R<T> success() {
        return new R(EResultCode.SUCCESS);
    }

    public static <T> R<T> success(T data) {
        return new R(EResultCode.SUCCESS, data);
    }

    public static <T> R<T> success(T data, String msg) {
        return new R(EResultCode.SUCCESS, data, msg);
    }

    // 失败
    public static <T> R<T> fail(EResultCode resultCode) {
        return new R(resultCode);
    }

    public static <T> R<T> fail(EResultCode resultCode, String msg) {
        return new R(resultCode, msg);
    }

    // set get
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
