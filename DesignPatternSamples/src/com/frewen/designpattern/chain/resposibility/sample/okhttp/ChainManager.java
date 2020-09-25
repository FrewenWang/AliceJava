package com.frewen.designpattern.chain.resposibility.sample.okhttp;

import java.util.ArrayList;
import java.util.List;

public class ChainManager {

    private List<Interceptor> interceptors = new ArrayList<>();

    public ChainManager() {
        interceptors.add(new InterceptorOne());
        interceptors.add(new InterceptorTwo());
        interceptors.add(new InterceptorThree());
    }

    public void dispatcher(Request request) {
        int index = 0;
        // 其实这个就像OKHttp里面的RealInterceptorChain
        ChainHolder chainHolder = new ChainHolder(interceptors, request, index);
        chainHolder.process();
    }
}
