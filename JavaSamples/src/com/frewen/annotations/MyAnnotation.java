package com.frewen.annotations;

import java.lang.annotation.*;

@Documented   //加上这个表示，可以被JavaDoc来扫描收录进去
@Target(ElementType.TYPE)  //这个表示这个注解只能被注解到类上面
@Retention(RetentionPolicy.RUNTIME)  //﻿若Annotation的类型为 RUNTIME，则意味着：编译器将Annotation存储于class文件中，并且可由JVM读入。
public @interface MyAnnotation {

}
