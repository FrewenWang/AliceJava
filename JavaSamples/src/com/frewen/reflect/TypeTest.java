package com.frewen.reflect;

public class TypeTest {


    public static void main(String[] args) {

        System.out.println("Animal.class.getSuperclass()\t"
                + Animal.class.getSuperclass());
        System.out.println("Animal.class.getGenericSuperclass()\t"
                + Animal.class.getGenericSuperclass());

        // 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class。
        // 也就是Animal 返回直接继承的父类（由于编译擦除，没有显示泛型参数）
        System.out.println("SmallCat.class.getSuperclass()\t"
                + SmallCat.class.getSuperclass());
        // 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        // 也就是Animal  返回直接继承的父类（包含泛型参数）
        // Animal.class.getGenericSuperclass()	com.frewen.reflect.Animal<com.frewen.reflect.Cat>
        System.out.println("Animal.class.getGenericSuperclass()\t"
                + SmallCat.class.getGenericSuperclass());


        System.out.println("Cat.class.getSuperclass()\t"
                + Cat.class.getSuperclass());
        System.out.println("Cat.class.getGenericSuperclass()\t"
                + Cat.class.getGenericSuperclass());

        System.out.println("Object.class.getGenericSuperclass()\t"
                + Object.class.getGenericSuperclass());
        System.out.println("Object.class.getSuperclass()\t"
                + Object.class.getSuperclass());

        System.out.println("void.class.getSuperclass()\t"
                + void.class.getSuperclass());
        System.out.println("void.class.getGenericSuperclass()\t"
                + void.class.getGenericSuperclass());

        System.out.println("int[].class.getSuperclass()\t"
                + int[].class.getSuperclass());
        System.out.println("int[].class.getGenericSuperclass()\t"
                + int[].class.getGenericSuperclass());
    }
}


class Animal<T> {

}

class SmallCat extends Animal<Cat> {

}
