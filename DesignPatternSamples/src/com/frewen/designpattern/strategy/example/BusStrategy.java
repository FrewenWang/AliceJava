package com.frewen.designpattern.strategy.example;

/**
 * 具体的策略实现类。
 * 这个是关于公交车的具体的策略实现类
 */
public class BusStrategy implements ICalculateStrategy {

    @Override
    public int calculatePrice(int km) {
        // 超过10公里的总距离
        int extraTotal = km - 10;
        // 超过的距离是5公里的倍数
        int extraFactor = extraTotal / 5;
        // 超过的距离对5公里取余
        int fraction = extraTotal % 5;
        // 价格计算
        int price = 1 + extraFactor * 1;
        return fraction > 0 ? ++price : price;
    }
}
