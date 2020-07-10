package com.frewen.designpattern.facade.architecture;

public class FacadeCharacter {

    private SubSystem01 obj1 = new SubSystem01();
    private SubSystem02 obj2 = new SubSystem02();
    private SubSystem03 obj3 = new SubSystem03();

    /**
     * 外观角色的调用方法
     */
    public void operation() {
        obj1.method1();
        obj2.method2();
        obj3.method3();
    }
}
