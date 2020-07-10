package com.frewen.designpattern.command

object ClientTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val command: ICommand = ConcreteCommand()
        val invoker = Invoker(command)
        println("客户访问调用者的call()方法...")
        invoker.call()
    }
}