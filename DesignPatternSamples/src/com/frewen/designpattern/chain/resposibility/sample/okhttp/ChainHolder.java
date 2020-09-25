package com.frewen.designpattern.chain.resposibility.sample.okhttp;

import java.util.List;

public class ChainHolder {


    private final Request request;
    private List<Interceptor> interceptors;
    private int index;

    public ChainHolder(List<Interceptor> interceptors, Request request, int index) {
        this.interceptors = interceptors;
        this.index = index;
        this.request = request;
    }

    public void process() {
        if (index >= interceptors.size()) {
            System.out.println("任务执行完毕");
            return;
        }
        // 我们取出责任链中的第index值的拦截器
        Interceptor interceptor = interceptors.get(index);
        // 但是这个地方需要注意传入的其实责任链的下一个拦截器
        interceptor.intercept(request);

        ChainHolder chainHolder = new ChainHolder(interceptors, request, index + 1);
        chainHolder.process();
    }
}
