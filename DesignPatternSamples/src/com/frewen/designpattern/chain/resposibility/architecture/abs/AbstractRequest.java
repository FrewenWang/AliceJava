package com.frewen.designpattern.chain.resposibility.architecture.abs;

/**
 * 责任链模式的基础框架设计：首先，这个是一个抽象的框架处理者.
 * 声明一个请求处理方法，然后具体的请求处理者类进行判断是自己处理，还是交给下一个节点处理。
 * 所以其中要持有下一个处理节点的Handler对象的引用。
 */
public abstract class AbstractRequest {
    /**
     * 等待处理的对象
     */
    protected String requestContent;


    public AbstractRequest(String content) {
        this.requestContent = content;
    }

    public Object getRequestContent() {
        return requestContent;
    }

    /**
     * 获取请求级别
     *
     * @return 请求级别
     */
    public abstract RequestLevel getRequestLevel();

}
