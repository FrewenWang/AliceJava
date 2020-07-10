package com.frewen.designpattern.strategy;

public class ConcreteStrategyA implements IStrategy {
    @Override
    public void strategyMethod1() {
        System.out.println("具体策略A的策略方法1被访问！");
    }

    @Override
    public void strategyMethod2() {
        System.out.println("具体策略A的策略方法2被访问！");
    }

    @Override
    public void strategyMethod3() {
        System.out.println("具体策略A的策略方法3被访问！");
    }
}
