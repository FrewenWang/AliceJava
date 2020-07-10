package com.frewen.designpattern.chain.resposibility.architecture;

import com.frewen.designpattern.chain.resposibility.architecture.abs.AbstractHandler;
import com.frewen.designpattern.chain.resposibility.architecture.abs.AbstractRequest;
import com.frewen.designpattern.chain.resposibility.architecture.abs.RequestLevel;

public class ConcreteHandler2 extends AbstractHandler {

    /**
     * 入参传入这个的责任对象所能处理问题的权限。当然这个权限可以通过其他的方法确认
     *
     * @param level
     */
    public ConcreteHandler2(RequestLevel level) {
        super(level);
    }

    @Override
    protected void handle(AbstractRequest request) {
        if (request.getRequestContent().equals("ConcreteHandler2")) {
            System.out.println("ConcreteHandler2 handled this request");
            return;
        }
    }
}
