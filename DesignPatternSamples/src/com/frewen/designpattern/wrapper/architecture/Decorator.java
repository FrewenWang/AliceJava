package com.frewen.designpattern.wrapper.architecture;

/**
 * 装饰模式：动态的给一个对象添加额外的功能。就增加功能来说，装饰模式比生成子类更加灵活。
 */
public abstract class Decorator extends Component {
    /**
     * 持有一个component对象引用。需要装饰的正是这个对象
     */
    private Component component;

    /**
     * 必要的构造方法，需要一个Component类型的参数
     *
     * @param component
     */
    protected Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void method1() {
        //调用实际的component的对应方法
        component.method1();
    }
}
