package com.frewen.designpattern.memento;

/**
 * 备忘录操作者
 */
public class CareTaker {

    Memeto memeto;

    public void archive(Memeto memeto){
        this.memeto = memeto;
    }

    public Memeto getMemeto() {
        return this.memeto;
    }
}
