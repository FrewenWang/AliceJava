package com.frewen.designpattern.chain.resposibility.sample.boss;

/**
 * 责任链模式的使用场景：多个对象处理同一个请求。但是具体由哪个对象处理则由运行时动态决定
 * <p>
 * 将这些对象连成一条链条，并沿着这个链条传递这个请求
 */
public class ClientTest {

    public static void main(String[] args) {
        //构造各个层次的领导
        GroupLeader groupLeader = new GroupLeader();
        DirectorLeader directorLeader = new DirectorLeader();
        ManagerLeader managerLeader = new ManagerLeader();
        Boss boss = new Boss();

        //设置上一级领导的处理者对象
        groupLeader.nextHandler = directorLeader;
        directorLeader.nextHandler = managerLeader;
        managerLeader.nextHandler = boss;

        //发起报账申请
        groupLeader.HandleRequest(50000);
    }

}
