package com.frewen.designpattern.wrapper.architecture;

/**
 * 具体的业务实现类
 */
public class ConcreteComponent extends Component {

    @Override
    public void method1() {
        System.out.println("ConcreteComponent called method1");
    }
}
