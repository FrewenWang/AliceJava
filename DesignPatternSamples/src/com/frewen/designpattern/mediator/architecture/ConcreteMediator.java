package com.frewen.designpattern.mediator.architecture;

public class ConcreteMediator extends Mediator {
    @Override
    public void method() {

        concreteColleagueA.action();
        concreteColleagueB.action();

    }
}
