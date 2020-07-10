package com.frewen.designpattern.chain.resposibility.architecture;

import com.frewen.designpattern.chain.resposibility.architecture.abs.AbstractHandler;
import com.frewen.designpattern.chain.resposibility.architecture.abs.AbstractRequest;
import com.frewen.designpattern.chain.resposibility.architecture.abs.RequestLevel;

public class ConcreteHandler1 extends AbstractHandler {


    public ConcreteHandler1(RequestLevel level) {
        super(level);
    }

    @Override
    protected void handle(AbstractRequest request) {
        if (request.getRequestContent().equals("ConcreteHandler1")) {
            System.out.println("ConcreteHandler1 handled this request");
            return;
        }
    }

}
