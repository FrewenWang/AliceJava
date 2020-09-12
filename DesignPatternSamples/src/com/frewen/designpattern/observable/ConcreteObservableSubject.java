package com.frewen.designpattern.observable;

import java.util.Observable;

public class ConcreteObservableSubject extends Observable {

    public void postNewPublication(String content) {
        // 标识状态或者内容发生改变
        setChanged();
        // 通知所有观察者
        notifyObservers(content);
    }
}
