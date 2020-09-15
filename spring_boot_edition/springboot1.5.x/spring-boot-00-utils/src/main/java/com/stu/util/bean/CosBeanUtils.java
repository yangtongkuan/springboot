package com.stu.util.bean;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/1/31 18:54
 * @To change this template use File | Settings | File Templates.
 * @desc 数据copy
 */
public class CosBeanUtils {

//    public static void main(String[] args) {
////        BeanUtils.copyProperties();
//    }
//
//    private static void copyProperties(Object source, Object target, String... ignoreProperties)
//            throws BeansException {
//
//        Assert.notNull(source, "Source must not be null");
//        Assert.notNull(target, "Target must not be null");
//
//        Class<?> actualEditable = target.getClass();
//        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
//        List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);
//
////        for (PropertyDescriptor targetPd : targetPds) {
////            Method writeMethod = targetPd.getWriteMethod();
////            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
////                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
////                if (sourcePd != null) {
////                    Method readMethod = sourcePd.getReadMethod();
////                    if (readMethod != null &&
////                            ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
////                        try {
////                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
////                                readMethod.setAccessible(true);
////                            }
////                            Object value = readMethod.invoke(source);
////                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
////                                writeMethod.setAccessible(true);
////                            }
////                            writeMethod.invoke(target, value);
////                        }
////                        catch (Throwable ex) {
////                            throw new FatalBeanException(
////                                    "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
////                        }
////                    }
////                }
////            }
////        }
//    }


}
