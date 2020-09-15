package com.stu.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "user_token")
public class UserTokenInfo implements Serializable {

    @Id
    private Long id;            // id
    private Long userId;      // 用户id
    private String token;       // token
    private Date createTime;    // 创建时间
    private Date expireTime;    // 失效时间
    private int delFlag = 0;    // 是否删除

    public Long getId() {
        return id;
    }

    public UserTokenInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserTokenInfo setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserTokenInfo setToken(String token) {
        this.token = token;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserTokenInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public UserTokenInfo setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public UserTokenInfo setDelFlag(int delFlag) {
        this.delFlag = delFlag;
        return this;
    }
}
