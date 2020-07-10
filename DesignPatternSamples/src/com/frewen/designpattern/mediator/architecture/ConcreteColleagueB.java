package com.frewen.designpattern.mediator.architecture;

/**
 * 具体的同事类B
 */
public class ConcreteColleagueB extends Colleague {


    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("ConcreteColleagueB action");
    }
}
