package com.frewen.reflect;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 文章参考:https://www.cnblogs.com/nihaorz/p/7595117.html
 * https://www.cnblogs.com/nihaorz/p/7595117.html
 *
 * @param <T>
 * @param <ID>
 */
public class GenericSuperClassDemo<T, ID extends Serializable> {

    private Class<T> clazz;

    public GenericSuperClassDemo() {
        System.out.println("=============GenericSuperClassDemo Constructor Called=================");
        //当前对象的直接超类的 Type
        Type genericSuperclass = getClass().getGenericSuperclass();
        System.out.println(genericSuperclass);

        if (genericSuperclass instanceof ParameterizedType) {
            //参数化类型
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            //返回表示此类型实际类型参数的 Type 对象的数组
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            this.clazz = (Class<T>) actualTypeArguments[1];
        } else {
            this.clazz = (Class<T>) genericSuperclass;
        }
    }

    public Class<T> getClazz() {
        return clazz;
    }


    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println("==============================");
        System.out.println(userService.getClazz());
    }

    public static class UserService extends GenericSuperClassDemo<Cat, Integer> {

    }

}
