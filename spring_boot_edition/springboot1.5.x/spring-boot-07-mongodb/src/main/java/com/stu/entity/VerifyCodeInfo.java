package com.stu.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/1/5 13:18
 * @To change this template use File | Settings | File Templates.
 */
@Document(collection = "verify_code")
public class VerifyCodeInfo implements Serializable {

    @Id
    private Long id;
    private String verifyType;
    private String username;
    private String telCode;
    private Date createTime; // 创建时间
    private Date expireTime; // 有效时间
    private int verifyState; // 验证状态

    public Long getId() {
        return id;
    }

    public VerifyCodeInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getVerifyType() {
        return verifyType;
    }

    public VerifyCodeInfo setVerifyType(String verifyType) {
        this.verifyType = verifyType;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public VerifyCodeInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getTelCode() {
        return telCode;
    }

    public VerifyCodeInfo setTelCode(String telCode) {
        this.telCode = telCode;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public VerifyCodeInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public VerifyCodeInfo setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    public int getVerifyState() {
        return verifyState;
    }

    public VerifyCodeInfo setVerifyState(int verifyState) {
        this.verifyState = verifyState;
        return this;
    }

    @Override
    public String toString() {
        return "VerifyCodeInfo{" +
                "id='" + id + '\'' +
                ", verifyType='" + verifyType + '\'' +
                ", username='" + username + '\'' +
                ", telCode='" + telCode + '\'' +
                ", createTime=" + createTime +
                ", expireTime=" + expireTime +
                ", verifyState=" + verifyState +
                '}';
    }
}

