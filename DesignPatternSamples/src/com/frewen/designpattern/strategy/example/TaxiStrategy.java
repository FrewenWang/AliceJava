package com.frewen.designpattern.strategy.example;

/**
 * 具体的策略实现类。
 * 这个是关于出租车的具体的策略实现类
 */
public class TaxiStrategy implements ICalculateStrategy {

    /**
     * 价格我们简单计算为公里数 * 2
     *
     * @param km 公里
     * @return
     */
    @Override
    public int calculatePrice(int km) {
        return km * 2;
    }
}
