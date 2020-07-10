package com.frewen.designpattern.adapter.classadapter;

import com.frewen.designpattern.adapter.Socket;
import com.frewen.designpattern.adapter.SocketAdapter;
import com.frewen.designpattern.adapter.Volt;

/**
 * 这是类适配器模式
 */
public class SocketClassAdapterImpl extends Socket implements SocketAdapter {
    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = getVolt();
        return convertVolt(v, 12);
    }

    @Override
    public Volt get3Volt() {
        Volt v = getVolt();
        return convertVolt(v, 40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }
}
