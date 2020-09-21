package com.frewen.designpattern.facade;

public class SumsunPhone implements IPhone {

    @Override
    public void dial() {
        System.out.println("打电话");
    }

    @Override
    public void hangup() {
        System.out.println("挂电话");
    }
}
