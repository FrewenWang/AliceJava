package com.frewen.designpattern.chain.resposibility.architecture;

import com.frewen.designpattern.chain.resposibility.architecture.abs.AbstractRequest;
import com.frewen.designpattern.chain.resposibility.architecture.abs.RequestLevel;

public class ClientTest {
    public static void main(String[] args) {
        //构造一个ConcreteHandler1对象
        ConcreteHandler1 handler1 = new ConcreteHandler1(RequestLevel.ONE);

        //构造一个ConcreteHandler2对象
        ConcreteHandler2 handler2 = new ConcreteHandler2(RequestLevel.TWO);
        handler1.setNextHandler(handler2);

        //处理请求
        handler1.handleRequest(new AbstractRequest("ConcreteHandler1") {
            @Override
            public RequestLevel getRequestLevel() {
                return RequestLevel.ONE;
            }
        });

        //处理请求
        handler1.handleRequest(new AbstractRequest("ConcreteHandler2") {
            @Override
            public RequestLevel getRequestLevel() {
                return RequestLevel.TWO;
            }
        });


    }
}
