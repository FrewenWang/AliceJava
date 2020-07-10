package com.frewen.designpattern.mediator.architecture;

public class ClientTest {

    public static void main(String[] args) {

        Mediator mediator = new ConcreteMediator();

        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);

        mediator.setConcreteColleagueA(colleagueA);
        mediator.setConcreteColleagueB(colleagueB);
        mediator.method();
    }
}
