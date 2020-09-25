package com.frewen.designpattern.chain.resposibility.sample.okhttp;

public class InterceptorThree implements Interceptor {
    @Override
    public void intercept(Request request) {
        System.out.println("InterceptorThree 拦截器三已经处理完毕");
    }
}
