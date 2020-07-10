package com.frewen.operator;

/**
 * 5、10、2、4 四个数字添加运算符使得计算结果为24
 */
public class OperatorTest {

    /**
     * 将1执行左移30为的操作
     * java中有三种移位运算符
     *
     *  <<      :     左移运算符，num << 1,相当于num乘以2
     *
     *  >>      :     右移运算符，num >> 1,相当于num除以2
     *
     *  >>>    :     无符号右移，忽略符号位，空位都以0补齐
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

        int a = (int) ((5 * 10 - 2) / (Math.sqrt(4)));

        int b = (int) ((5 / 10 * 2) * (Math.sqrt(4)));

        int c = 5 % 10;

        int d = 5 / (10 - 2);
        System.out.println("a=" + a);

        System.out.println("c=" + c);

        System.out.println("d=" + d);

        shiftOperationTest();

    }

    /**
     * 进行移位计算的相关逻辑
     */
    private static void shiftOperationTest() {

        System.out.println("OperatorTest.shiftOperationTest MAXIMUM_CAPACITY="+MAXIMUM_CAPACITY);

        System.out.println("OperatorTest.shiftOperationTest tableSizeFor = "+tableSizeFor(3));

    }


    /**
     * 先说明 |=的作用：a |= b 等同于 a = a|b
     *
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
