package com.frewen.oop;

public class InheritanceClass extends BaseClass {

    /**
     * 子类 调用 父类的构造函数：（构造函数不会被继承，只是被子类调用而已）
     * <p>
     * 1、子类所有的 构造函数 默认调用父类的无参构造函数（其实是默认省略掉了一行代码：super();）;
     * 省略掉的这行super()代码可以自行添加到构造函数的第一行（必须是第一行，否则报错）
     * <p>
     * 2、如果父类没有定义构造函数，系统会默认定义一个无参无返回值的构造函数，
     * 子类继承时无需（无需的意思是：可以写可以不写）在子类构造函数中显式调用super( )；
     * 如果父类定义了构造函数，系统不会再默认定义任何 无参无返回值 的构造函数,
     * 此时子类的构造函数中必须显式调用super( [arg0][,arg1]….),
     * 即，显式调用对应的参数个数、对应参数类型与此super( [arg0][,arg1]…. )的父类构造函数。
     * <p>
     * <p>
     * 3、如果子类的某个构造函数 想 调用父类的其他的带参数的构造函数，在构造函数的第一行人为添加 super(val1,val2[,val3…]),super()括号中的变量数量由想调用的父类的构造函数中的变量数量决定。如代码中的line 2，调用的是父类构造函数中两个参数的构造函数，那么Super(20,”Hello”)就两个变量。
     * <p>
     * 4、自行添加super(val1,val2,…),就可以指定调用父类的那个参数类型和数量一致的构造函数。之后在此子类构造函数中，系统不会再默认调用父类无参构造函数；
     * <p>
     * 5、如果子类的每个构造函数都自行添加super([val1,]….),除非人为调用父类无参构造函数，否则的话父类的无参构造函数可以不写。有super指定调用的父类构造函数存在即可
     * <p>
     * 2017-7-25追加
     * 6、super指代 父类对象 可以在子类中使用 super.父类方法名();调用父类中的方法（无论是类方法还是实例方法都可以，除此调用实例方法的还可以在方法内部实例化再调用）
     */
    public InheritanceClass() {
//        super("");
        System.out.println("InheritanceClass constructor called");
    }

    public InheritanceClass(String name) {
//        super("");
        System.out.println("InheritanceClass constructor called:" + name);
    }

    public static void main(String[] args) {
        InheritanceClass inheritanceClass = new InheritanceClass("你好");
    }
}
