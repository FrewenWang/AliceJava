package com.frewen.designpattern.adapter;

/**
 * 这是一个插座
 */
public class Socket {
    /**
     * 插入哦插座得到120V的电压
     * <p>
     * Now we want to build an adapter that can produce 3 volts, 12 volts and default 120 volts.
     * So first of all we will create an adapter interface with these methods.
     *
     * @return
     */
    public Volt getVolt() {
        return new Volt(120);
    }
}
