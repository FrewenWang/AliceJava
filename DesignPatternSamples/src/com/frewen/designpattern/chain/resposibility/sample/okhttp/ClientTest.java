package com.frewen.designpattern.chain.resposibility.sample.okhttp;

/**
 * 这个我们来模拟OKHttp的的实现，来写一版本OKHttp的实现逻辑
 */
public class ClientTest {

    public static void main(String[] args) {

        Request request = new ConcreteRequest();

        // 责任链的调度处理，我们把他放在Dispatcher
        // 这个Dispatcher大家不要和OKHttp里面的Dispatcher不是一个概念

        new ChainManager().dispatcher(request);


    }
}
