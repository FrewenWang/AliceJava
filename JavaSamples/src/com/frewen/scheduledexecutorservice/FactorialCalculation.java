package com.frewen.scheduledexecutorservice;

/**
 * 模拟一个阶乘计算的业务逻辑
 */
public class FactorialCalculation implements Runnable {

    private Integer number;

    public FactorialCalculation(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        int result = 1;
        if (number == 0) {
            System.out.println("0!=" + "1");
        }
        if (number > 5) {
            System.out.println("exception");
            throw new IllegalArgumentException(">5");
        }
        for (int i = 1; i <= number; i++) {
            result *= i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(number + "!=" + result);
    }
}
