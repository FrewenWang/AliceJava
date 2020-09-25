package com.frewen.designpattern.chain.resposibility.sample.boss;

public class Boss extends Leader {
    @Override
    protected void handle(int money) {
        System.out.println("老板报销" + money + "元");
    }

    @Override
    protected int maxLimit() {
        return Integer.MAX_VALUE;
    }
}
