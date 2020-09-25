package com.frewen.designpattern.chain.resposibility.sample.okhttp;

public class InterceptorOne implements Interceptor {
    @Override
    public void intercept(Request request) {
        System.out.println("InterceptorOne 拦截器一已经处理完毕");
    }
}
