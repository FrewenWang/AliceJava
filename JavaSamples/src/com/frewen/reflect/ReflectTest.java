package com.frewen.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ReflectTest {
    public static void main(String[] args) {


        testFiled();

        //1、通过ReflectObj.class 这种形式
        // 其实这种方式也很好理解，我们都知道ReflectObj.class是Class类型的实例嘛
        Class clazz = ReflectObj.class;


        //1、通过一个对象获得完整的包名和类名
        ReflectObj reflectObj = new ReflectObj();
        System.out.println(reflectObj.getClass().getName());

        //反射获取Class对象 一般尽量采用这种形式。通过类的全限定名
        Class<?> reflectObj1 = null;
        Class<?> reflectObj2 = null;
        Class<?> reflectObj3 = null;

        try {
            //反射获取Class对象 一般尽量采用这种形式
            reflectObj1 = Class.forName("com.frewen.reflect.ReflectObj");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        reflectObj2 = new ReflectObj().getClass();

        reflectObj3 = ReflectObj.class;
        System.out.println("类名称   " + reflectObj1.getName());
        System.out.println("类名称   " + reflectObj2.getName());
        System.out.println("类名称   " + reflectObj3.getName());


        //2、通过Class实例化其他类的对象
        Class<?> reflectObjInstance = null;
        ReflectObj obj = null;

        try {
            reflectObjInstance = Class.forName("com.frewen.reflect.ReflectObj");
            obj = (ReflectObj) reflectObjInstance.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        obj.setId(1000);
        obj.setName("ReflectObj");
        System.out.println(obj.toString());

        //但是注意一下，当我们把Person中的默认的无参构造函数取消的时候，比如自己定义只定义一个有参数的构造函数之后，会出现错误：


        //3、加入一个类中有多个构造函数。那我们怎么使用Class调用多个构造函数实例化类对象
        // 通过Class调用其他类中的构造函数 （也可以通过这种方式通过Class创建其他类的对象）
        Class<?> classObj = null;
        ReflectObj reflectMultiConstructorObj1 = null;
        ReflectObj reflectMultiConstructorObj2 = null;
        ReflectObj reflectMultiConstructorObj3 = null;

        try {

            classObj = Class.forName("com.frewen.reflect.ReflectObj");
            //取得全部的构造函数
            Constructor<?> cons[] = classObj.getConstructors();
            //通过ReflectObj的无参构造函数来实例化对象
            reflectMultiConstructorObj1 = (ReflectObj) classObj.newInstance();

            //
            //reflectMultiConstructorObj2 = (ReflectObj) classObj.getConstructor(Integer.class).newInstance(10);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    private static void testFiled() {
        // 通过.class的语法获取Cat的Class类型的实例
        Class clazz = Cat.class;
        // 获取指定的变量（只要是声明的变量都能获得，包括private）
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            StringBuilder builder = new StringBuilder();
            //获取名称
            builder.append("filed name = ");
            builder.append(field.getName());
            //获取类型
            builder.append(" type = ");
            builder.append(field.getType());
            //获取修饰符
            builder.append(" modifiers = ");
            builder.append(Modifier.toString(field.getModifiers()));

            //获取注解
            Annotation[] ann = field.getAnnotations();
            if (ann.length != 0) {
                builder.append(" annotations = ");
                for (Annotation a : ann) {
                    builder.append(a.toString());
                    builder.append(" ");
                }
            } else {
                builder.append("  -- No Annotations --");
            }


            System.out.println("field:" + builder.toString());
        }
    }
}
