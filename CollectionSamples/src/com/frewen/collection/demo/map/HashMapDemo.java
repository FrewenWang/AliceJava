package com.frewen.collection.demo.map;

import java.util.HashMap;
public class HashMapDemo {

    private static int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();


        //计算Key值的Hash值
        //int hash = hash(new Integer(15));
        int hash = hash(new String("1245"));
        System.out.println("hash()==" + hash);


        //计算HashMap在初始化的时候,
        System.out.println("tableSizeFor = " + tableSizeFor(16));

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * 计算Key值的HashCode
     *
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        System.out.println("h = key.hashCode()==" + (h = key.hashCode()) + ",二进制：" + Integer.toBinaryString(h));

        System.out.println("h >>> 16==" + (h >>> 16) + "，二进制：" + Integer.toBinaryString(h >>> 16));

        System.out.println("(h = key.hashCode()) ^ (h >>> 16) ==二进制：" + Integer.toBinaryString(((h = key.hashCode()) ^ (h >>> 16))));
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
