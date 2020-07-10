package com.frewen.designpattern.mediator.architecture;


/**
 * 这是一个抽象中介者
 */
public abstract class Mediator {
    /**
     * 具体的同事类A
     */
    protected ConcreteColleagueA concreteColleagueA;
    /**
     * 具体的同事类B
     */
    protected ConcreteColleagueB concreteColleagueB;

    public abstract void method();


    public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }
}
