package com.frewen.designpattern.chain.resposibility.sample.okhttp;

public class InterceptorTwo implements Interceptor {
    @Override
    public void intercept(Request request) {
        System.out.println("InterceptorTwo 拦截器二已经处理完毕");
    }
}
