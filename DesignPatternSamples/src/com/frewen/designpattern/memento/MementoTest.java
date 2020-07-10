package com.frewen.designpattern.memento;

/**
 * 备忘录模式是一种行为设计模式。该模式用于保存对象的当前状态。并且在之后可以恢复为之前的状态。
 * 这有点向向我们之前所说的后悔药
 */

/**
 * 定义：在不破坏封闭的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，这样以后就可以将该对象恢复到之前的状态。
 */
public class MementoTest {
    public static void main(String[] args) {
        //构建游戏对象
        CallOfDutyGame callOfDutyGame = new CallOfDutyGame();
        //1、打游戏
        callOfDutyGame.playGame();
        callOfDutyGame.playGame();

        CareTaker careTaker = new CareTaker();
        careTaker.archive(callOfDutyGame.createMemeto());

        //3.退出游戏
        callOfDutyGame.quitGame();

        //4.恢复游戏
        CallOfDutyGame newCallOfDutyGame = new CallOfDutyGame();
        newCallOfDutyGame.restoreMemeto(careTaker.getMemeto());

    }
}
