package com.frewen.designpattern.mediator.architecture;

/**
 * 抽象角色类
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 具体角色的具体行为。交由子类去实现
     */
    public abstract void action();
}
