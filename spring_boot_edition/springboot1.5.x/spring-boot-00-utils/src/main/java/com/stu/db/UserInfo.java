package com.stu.db;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/26 10:22
 * @To change this template use File | Settings | File Templates.
 */
@Data
@Accessors(chain = true)
public class UserInfo implements Serializable {
    private Long id;                    // 用户id 用户的key
    private String sysCustomer;        // 客户标识
    private String username;            // 系统账号
    private String email;               // email
    private String phone;               // 手机号
    private String lastName;           // 用户姓名
    private String prov;                // 省市区
    private String city;
    private String country;
    private String address;             // 地址
    private Double lat;
    private Double lng;
    // 推荐信息
    private String recommendId;         // 推荐者id
    // 其他的信息
    private int del = 0;                // 删除
    private Long createId;              // 创建者
    private Date createTime;            // 创建时间
    private Long updateUserId;          // 最后更新者
    private Date updateTime;            // 最后更新时间
}
