package com.frewen.trycatch;

import java.util.ArrayList;
import java.util.List;

public class TryCatchTest {


    public static void main(String[] args) {

        // System.out.println("catchReturnTest = [" + catchReturnTest() + "]");


        // System.out.println("finallyReturnTest = [" + finallyReturnTest() + "]");

        System.out.println("finallyReturnTest = [" + finallyNoReturnTest() + "]");

        // System.out.println("catchAndFinallyReturnTest = [" + catchAndFinallyReturnTest() + "]");

        // System.out.println("finallyExitTest = [" + finallyExitTest() + "]");
    }

    /**
     * finally语句中没有返回值的时候
     *
     * @return
     */
    private static String finallyNoReturnTest() {
        try {
            System.out.println("try body called");
            int i = 10 / 0;  // 抛出异常
            System.out.println("i vaule is : " + i);
            return "try body return";    // 获得被执行的机会，但执行需要在 finally 执行完成之后才能被执行
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            System.out.println("catch  body  called  ");
            return "catch body return";
        } finally {
            System.out.println("finally  body  called  ");

        }
    }

    private static String finallyExitTest() {
        try {
            System.out.println("try body called");
            // System.exit(0);// System.exit() 语句，System.exit() 将退出整个程序，程序将被终止
            int i = 10 / 0;  // 抛出异常
            System.out.println("i vaule is : " + i);
            return "try body return";    // 获得被执行的机会，但执行需要在 finally 执行完成之后才能被执行
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            System.out.println("catch  body  called  ");
            // System.exit(0);// System.exit() 语句，System.exit() 将退出整个程序，程序将被终止
            return "catch body return";
        } finally {
            System.out.println("finally  body  called  ");
            System.exit(0);// finally 中含有 System.exit() 语句，System.exit() 将退出整个程序，程序将被终止
            return "finally body return"; // 不会执行。System.exit() 将退出整个程序，程序将被终止
        }
    }

    private static String catchAndFinallyReturnTest() {
        try {
            System.out.println("try body called");
            int i = 10 / 0;  // 抛出异常
            System.out.println("i vaule is : " + i);
            return "try body return";    // 获得被执行的机会，但执行需要在 finally 执行完成之后才能被执行
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            System.out.println("catch  body  called  ");
            return "catch body return";
        } finally {
            System.out.println("finally  body  called  ");
            return "finally body return"; // finally 中含有 return 语句，这个 return 将结束这个方法，不会在执行完之后再跳回 try 或 catch 继续执行，方法到此结束，返回 false
        }
    }

    /**
     * try体不抛异常。并且有finally体有return语句。是怎么处理？
     *
     * @return
     */
    private static String finallyReturnTest() {
        try {
            System.out.println("try body called");
            int i = 10 / 2;  // 不抛出 Exception
            System.out.println("i vaule is : " + i);
            return "try body return";    // 获得被执行的机会，但执行需要在 finally 执行完成之后才能被执行
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            System.out.println("catch  body  called  ");
            return "catch body return";
        } finally {
            System.out.println("finally  body  called  ");
            return "finally body return"; // finally 中含有 return 语句，这个 return 将结束这个方法，不会在执行完之后再跳回 try 或 catch 继续执行，方法到此结束，返回 false
        }
    }

    /**
     * catch 体里遇到 return 是怎么处理？
     */
    private static String catchReturnTest() {
        try {
            System.out.println("try body called");
            int i = 10 / 0;   // 抛出 Exception，后续处理被拒绝
            System.out.println("i vaule is : " + i);
            return "try body return";    // Exception 已经抛出，没有获得被执行的机会
        } catch (Exception e) {
            System.out.println(" -- Exception Catch--" + e);
            System.out.println("catch  body  called  ");
            return "catch body return";    // Exception 抛出，获得了调用方法并返回方法值的机会
        }
    }


    /**
     * 综上所述：
     * 别看场景分的挺多。其实就是总结最根本的一点：
     * - 如果有System.exit(0)语句。能执行到System.exit(0)语句的时候。程序直接退出。
     * - 没有System.exit(0)语句的话，如果有finally语句。则finally语句一定都会执行，如果finnaly有返回值。则返回finally体的返回值。
     * 如果没有返回值，则执行完所有finnal语句之后。则能执行到catch就返回catch。不能就返回try体的返回值。
     * - 没有finally体的话。异常就返回catch体的返回值。没有异常就返回try体的返回值。
     */

}
