package com.frewen.designpattern.strategy.example;

/**
 * 这个接口就是抽象的价格计算策略方法
 */
public interface ICalculateStrategy {

    /**
     * 按距离来计算价格
     *
     * @param km 公里
     * @return 返回价格
     */
    int calculatePrice(int km);
}
