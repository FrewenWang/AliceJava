package com.frewen.designpattern.strategy.example;

/**
 * 我们来说一下策略模式的优点：
 *
 * 通过建立抽象，将不同的策略构建成一个具体的策略实现，通过不同的策略实现算法替换。
 * 在简化逻辑、结构的同时，增强了系统的可读性、稳定性、可扩展性，这对于较为复杂的业务逻辑显得更为直观，扩展也更为方便。
 */
public class ClientTest {

    // 公交车类型
    private static final int BUS = 1;
    // 地铁类型
    private static final int SUBWAY = 2;

    public static void main(String[] args) {
        testStrategyPattern();
    }

    private static void testStrategyPattern() {
        ClientTest client = new ClientTest();
        // 设置计算策略
        client.setStrategy(new BusStrategy());
        System.out.println("坐16公里的公交车票价为 : " + client.calculatePrice(16));

        // 设置计算策略
        client.setStrategy(new SubwayStrategy());
        System.out.println("坐16公里的地铁票价为 : " + client.calculatePrice(16));
    }


    ICalculateStrategy mStrategy;

    public void setStrategy(ICalculateStrategy strategy) {
        this.mStrategy = strategy;
    }

    public int calculatePrice(int km) {
        return mStrategy.calculatePrice(km);
    }

}
