package com.matcha.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/13 21:21
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Data
@Accessors(chain = true)
public class UserEntity implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private Date bir;

}
