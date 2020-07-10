package com.frewen.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 测试注解支持的元素数据类型的注解声明
 */
public @interface AnnotationElementTest {

    //声明枚举
    Status status() default Status.FIXED;

    //枚举类型
    enum Status {FIXED, NORMAL}


    //布尔类型
    boolean showSupport() default false;

    //String类型
    String name() default "";

    //class类型
    Class<?> testCase() default Void.class;

    //注解嵌套
    NestAnnotation nestValue() default @NestAnnotation(nestValue = true);

    //数组类型
    long[] value();


}

/**
 * 用于测试嵌套数据类型的注解声明
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface NestAnnotation {

    boolean nestValue() default false;
}
