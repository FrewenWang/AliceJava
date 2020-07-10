package com.frewen.designpattern.adapter.objectadapter;

import com.frewen.designpattern.adapter.Socket;
import com.frewen.designpattern.adapter.SocketAdapter;
import com.frewen.designpattern.adapter.Volt;

/**
 * 对象适配器模式
 */
public class SocketObjectAdapterImpl implements SocketAdapter {

    /**
     * Using Composition for adapter pattern
     * 适配器实现类对象和原有对象是组合关系
     */
    private Socket sock = new Socket();

    @Override
    public Volt get120Volt() {
        return sock.getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = sock.getVolt();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = sock.getVolt();
        return convertVolt(v, 40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }
}
