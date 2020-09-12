package com.frewen.designpattern.observable;

public class ClientTest {

    public static void main(String[] args) {

        ConcreteObservableSubject concreteObservableSubject = new ConcreteObservableSubject();

        // 然后实例化观察者。我们设置一批观察者
        ConcreteObserverSubject concreteObserverSubject1 = new ConcreteObserverSubject("观察者1");
        ConcreteObserverSubject concreteObserverSubject2 = new ConcreteObserverSubject("观察者2");
        ConcreteObserverSubject concreteObserverSubject3 = new ConcreteObserverSubject("观察者3");
        ConcreteObserverSubject concreteObserverSubject4 = new ConcreteObserverSubject("观察者4");

        // 将观察者注册到可观察对象的观察者列表中
        concreteObservableSubject.addObserver(concreteObserverSubject1);
        concreteObservableSubject.addObserver(concreteObserverSubject2);
        concreteObservableSubject.addObserver(concreteObserverSubject3);
        concreteObservableSubject.addObserver(concreteObserverSubject4);

        // 发布消息
        concreteObservableSubject.postNewPublication("新的—期开发技术前线周报发布啦!");

    }
}
