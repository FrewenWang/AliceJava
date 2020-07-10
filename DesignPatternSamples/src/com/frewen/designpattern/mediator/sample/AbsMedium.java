package com.frewen.designpattern.mediator.sample;

/**
 * 定义抽象中介者
 */
public interface AbsMedium {
    void register(Customer member); //客户注册

    void relay(String from, String ad); //转发

}
