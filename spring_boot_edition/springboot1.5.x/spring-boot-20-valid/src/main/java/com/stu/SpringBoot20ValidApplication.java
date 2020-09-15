package com.stu;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * JSR303
 .  1.)在需要验证的bean的属性上加上注解 (javax.validation.constraints)  @NotBlank 并定义自己的message提示
 *  2.)在方法参数上添加@Valid注解  开始验证
 *      效果：校验错误以后会有默认的响应；
 *  3)、给校验的bean后紧跟一个BindingResult，就可以获取到校验的结果
 *  4）、分组校验（多场景的复杂校验）
 *         1)、	@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
 *          给校验注解标注什么情况需要进行校验
 *         2）、@Validated({AddGroup.class})
 *         3)、默认没有指定分组的校验注解@NotBlank，在分组校验情况@Validated({AddGroup.class})下不生效，只会在@Validated生效；
 *
 *  5）、自定义校验
 *        1）、编写一个自定义的校验注解
 *        2）、编写一个自定义的校验器 ConstraintValidator
 *        3）、关联自定义的校验器和自定义的校验注解
 *          *      @Documented
 *          *@Constraint(validatedBy = {ListValueConstraintValidatorForInteger.class,
 *         ListValueConstraintValidatorForLong.class, ListValueConstraintValidatorForString.class})【可以指定多个不同的校验器，适配不同类型的校验】 })
 *          * @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
 *          * @Retention(RUNTIME)
 *          * public @interface ListValue {
 */
@SpringBootApplication
@EnableSwaggerBootstrapUI
public class SpringBoot20ValidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot20ValidApplication.class, args);
    }

}
