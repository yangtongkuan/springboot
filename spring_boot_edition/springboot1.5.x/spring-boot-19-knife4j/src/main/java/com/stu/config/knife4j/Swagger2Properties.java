package com.stu.config.knife4j;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/26
 * @To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties(prefix = "swagger2")
@Component
@Data
public class Swagger2Properties {
    private String author;          // 作者
    private String url;             // 连接地址
    private String email;           // 邮箱
    private String title;           // 邮箱
    private String desc;           // 邮箱
    private String version;           // 邮箱


}
