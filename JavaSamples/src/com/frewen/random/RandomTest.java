package com.frewen.random;

import java.util.Random;

/**
 * 测试随机数的生成
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(8);

        System.out.println("random == " + i);
    }
}
