package com.frewen.designpattern.mediator.architecture;

/**
 * 具体的同事类A
 */
public class ConcreteColleagueA extends Colleague{


    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("ConcreteColleagueA  action");
    }
}
