package com.frewen.designpattern.strategy;

/**
 * 具体策略B
 */
public class ConcreteStrategyB implements IStrategy {
    @Override
    public void strategyMethod1() {
        System.out.println("具体策略B的策略方法1被访问！");
    }

    @Override
    public void strategyMethod2() {
        System.out.println("具体策略B的策略方法2被访问！");
    }

    @Override
    public void strategyMethod3() {
        System.out.println("具体策略B的策略方法3被访问！");
    }
}
