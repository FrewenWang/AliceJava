package com.frewen.designpattern.strategy;

public class ClientTest {

    private IStrategy strategy;

    public IStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod1() {
        strategy.strategyMethod1();
    }

    public void strategyMethod2() {
        strategy.strategyMethod2();
    }

    public void strategyMethod3() {
        strategy.strategyMethod3();
    }

    public static void main(String[] args) {
        ClientTest clientTest = new ClientTest();
        clientTest.setStrategy(new ConcreteStrategyA());

        clientTest.strategyMethod1();
        clientTest.strategyMethod2();
        clientTest.strategyMethod3();

        clientTest.setStrategy(new ConcreteStrategyB());
        clientTest.strategyMethod1();
        clientTest.strategyMethod2();
        clientTest.strategyMethod3();

    }
}
