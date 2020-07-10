package com.frewen.annotations;


import java.lang.annotation.*;

/**
 * 自定义的Annotation。
 * <p>
 * Inherited注解的实现如下：
 *
 * @Documented 可以被写进Javadoc
 * @Retention(RetentionPolicy.RUNTIME) //可以﻿编译器会将Inherited的信息保留在.class文件中，并且能被虚拟机读取。
 * @Target(ElementType.ANNOTATION_TYPE) //﻿@Inherited只能被用来标注“Annotation类型”。
 * public @interface Inherited {}
 * ﻿它所标注的Annotation将具有继承性。
 */
@Target(ElementType.TYPE)   //这个自定义注解是可以是的类具有继承属性
@Retention(RetentionPolicy.RUNTIME)   //可以﻿编译器会将Inherited的信息保留在.class文件中，并且能被虚拟机读取。
@Inherited
        //这个及时是的当父类标注为Inheritable这个注解，则它的子类也自动有了这个注解。
@interface Inheritable {

}

@Inheritable
class InheritableFather {

    public InheritableFather() {
        // InheritableFather是否具有 Inheritable Annotation
        System.out.println("InheritableFather:" + InheritableFather.class.isAnnotationPresent(Inheritable.class));
    }
}

/**
 * InheritableTest 类只是继承于 InheritableFather，
 */
public class InheritableTest extends InheritableFather {

    public InheritableTest() {
        super();    // 调用父类的构造函数
        // InheritableSon类是否具有 Inheritable Annotation
        System.out.println("InheritableSon:" + InheritableTest.class.isAnnotationPresent(Inheritable.class));
    }

    public static void main(String[] args) {
        InheritableTest is = new InheritableTest();
    }
}