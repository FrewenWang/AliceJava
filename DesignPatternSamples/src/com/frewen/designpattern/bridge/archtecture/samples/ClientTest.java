package com.frewen.designpattern.bridge.archtecture.samples;

/**
 * 桥接模式就是典型的抽象与实现部分进行分离。使他们可以独立的进行变化
 *
 * 产品纽带联系的只是两者业务的高层抽象之前的耦合关系，尽量让和我变得小一些。
 *
 * 这个遵循设计模式中的
 * 1、接口隔离原则。我们看到桥接关系中，我们使用接口进行桥接聚合。而不是直接使用实现来进行聚合。
 * 2、依赖倒置原则：我看到桥接关系中，都是高层模块之前的依赖关系，两者的依赖关系都是其抽象，而不是细节。
 *
 * 下面就是软件设计模式的七大原则
 * 1、单一职责： 有且仅有一个变量的变化会引起这个类变化，此类保证职责单一
 * 2、开闭原则：保证系统稳定的基础之上，要保证对扩展开放，对修改关闭
 * 3、里氏替换：子类可以扩展父类功能，但是不能修改父类功能。（其实也是开闭原则的要求）
 *
 * 4、依赖倒置： 高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象
 * 5、迪米特法则：也叫最少知道原则。就是软件设计原则是一个类如果不需要知道另一个类，那么久尽量不要产生联系。
 *             如果其中的一个类需要调用另一个类的某一个方法的话,可以通过第三者转发这个调用。
 * 6、接口隔离：一个类对另一个类的依赖应该建立在接口之上。并且单独的功能最好使用单独的接口，不要使用统一接口
 * 7、合成/聚合复用原则：在一个新的对象里面使用一些已有的对象,使之成为新对象的一部分;
 *                  新的对象通过这些向对象的委派达到复用已有功能的目的.
 *                  这个设计原则有另一个简短的表述:要尽量使用合成/聚合,尽量不要使用继承.
 */
public class ClientTest {

    public static void main(String[] args) {
        // 原计原味
        Ordinary implOrdinary = new Ordinary();
        // 准备糖类
        Sugar implSugar = new Sugar();
        // 大杯咖啡 原味
        LargeCoffee largeCoffeeOrdinary = new LargeCoffee(implOrdinary);
        largeCoffeeOrdinary.makeCoffee();
        // 小杯咖啡 原味
        SmallCoffee smallCoffeeOrdinary = new SmallCoffee(implOrdinary);
        smallCoffeeOrdinary.makeCoffee();
        // 大杯咖啡 加糖
        LargeCoffee largeCoffeeSugar = new LargeCoffee(implSugar);
        largeCoffeeSugar.makeCoffee();
        // 小杯咖啡 加糖
        SmallCoffee smallCoffeeSugar = new SmallCoffee(implSugar);
        smallCoffeeSugar.makeCoffee();
    }
}
