package com.stu.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义注解验证器
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {
    private boolean require = true;
    private Set<Integer> set = new HashSet<>();

    @Override
    public void initialize(ListValue constraintAnnotation) {
        // 同一个地方只会初始化一次
        this.require = constraintAnnotation.require();
        int[] values = constraintAnnotation.values();
        for (int value : values) {
            set.add(value);
        }
    }

    @Override
    public boolean isValid(Integer key, ConstraintValidatorContext constraintValidatorContext) {
        if (!require) {
            if (key == null) {
                return true;
            }
        }
        if (key == null) {
            return false;
        }
        return this.set.contains(key);
    }
}
