package com.frewen.designpattern.iterator.architecture;

public class ClientTest {
    public static void main(String[] args) {
        IComponent ag = new ConcreteComponent();
        ag.add("First");
        ag.add("Second");
        ag.add("Third");
        System.out.print("聚合的内容有：");
        Iterator it = ag.getIterator();

        while (it.hasNext()) {
            Object ob = it.next();
            System.out.print(ob.toString() + "\t");
        }
        Object ob = it.first();
        System.out.println("\nFirst：" + ob.toString());
    }
}
