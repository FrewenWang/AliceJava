package com.frewen.designpattern.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 抽象主题
 */
public class ConcreteObserverSubject implements Observer {

    public String name;

    public ConcreteObserverSubject(String observerName) {
        this.name = observerName;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Hi, " + name + ", 更新啦, 内容 : " + arg);
    }


}
