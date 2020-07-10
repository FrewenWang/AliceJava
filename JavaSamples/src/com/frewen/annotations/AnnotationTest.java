package com.frewen.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Annotation在反射函数中的使用示例
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotations {
    String[] value() default "unknown";
}

class Person {

    @MyAnnotations("unknown")
    @Deprecated
    public void empty() {
        System.out.println("\nempty");
    }

    /**
     * sombody() 被 @MyAnnotation(value={"girl","boy"}) 所标注，
     * MyAnnotations的值是一个数组
     *
     * @MyAnnotations(value={"girl","boy"}), 意味着MyAnnotations的value值是{"girl","boy"}
     */
    @MyAnnotations(value = {"girl", "boy"})
    public void somebody(String name, int age) {
        System.out.println("\nsomebody: " + name + ", " + age);
    }

}

public class AnnotationTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Person person = new Person();
        person.empty();
        //这样是可以打印出来的，下一步我们尝试使用反射+注解。然后将这个两个值参数传入，看打印情况
        person.somebody("frewen", 12);


        // 新建Person
        Person person11 = new Person();
        // 获取Person的Class实例
        Class<Person> c = Person.class;
        // 获取 somebody() 方法的Method实例。这个反射抛出NoSuchMethodException
        Method mSomebody = c.getMethod("somebody", new Class[]{String.class, int.class});
        // 执行该方法  这个反射抛出InvocationTargetException, IllegalAccessException
        mSomebody.invoke(person11, new Object[]{"lily", 18});

        iteratorAnnotations(mSomebody);

        // 获取 somebody() 方法的Method实例
        Method mEmpty = c.getMethod("empty", new Class[]{});
        // 执行该方法
        mEmpty.invoke(person, new Object[]{});
        iteratorAnnotations(mEmpty);
    }


    public static void iteratorAnnotations(Method method) {

        // 判断 somebody() 方法是否包含MyAnnotation注解
        if (method.isAnnotationPresent(MyAnnotations.class)) {
            // 获取该方法的MyAnnotations注解实例
            MyAnnotations myAnnotation = method.getAnnotation(MyAnnotations.class);
            // 获取 myAnnotation的值，并打印出来
            String[] values = myAnnotation.value();
            for (String str : values) {
                System.out.printf(str + ",,, ");
            }
            System.out.println();
        }

        // 获取方法上的所有注解，并打印出来
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
