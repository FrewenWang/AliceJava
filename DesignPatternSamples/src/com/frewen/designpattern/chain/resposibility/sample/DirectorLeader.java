package com.frewen.designpattern.chain.resposibility.sample;

public class DirectorLeader extends Leader {
    @Override
    protected void handle(int money) {
        System.out.println("主管报销" + money + "元");
    }

    @Override
    protected int maxLimit() {
        return 5000;
    }
}
