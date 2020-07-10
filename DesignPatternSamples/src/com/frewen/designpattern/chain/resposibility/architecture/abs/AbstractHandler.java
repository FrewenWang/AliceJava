package com.frewen.designpattern.chain.resposibility.architecture.abs;

/**
 * 责任链模式的基础框架设计：首先，这个是一个抽象的框架处理者.
 * 声明一个请求处理方法，然后具体的请求处理者类进行判断是自己处理，还是交给下一个节点处理。
 * 所以其中要持有下一个处理节点的Handler对象的引用。
 */
public abstract class AbstractHandler {
    /**
     * 所能处理的问题的级别权限
     */
    protected RequestLevel level;
    /**
     * 下一个节点的任务处理者
     */
    protected AbstractHandler nextHandler;

    /**
     * 入参传入这个的责任对象所能处理问题的权限。当然这个权限可以通过其他的方法确认
     *
     * @param level
     */
    public AbstractHandler(RequestLevel level) {
        this.level = level;
    }

    /**
     * 请求处理
     *
     * @param request 处理请求
     */
    public final void handleRequest(AbstractRequest request) {
        if (getHandlerLevel() == request.getRequestLevel()) {
            //请求和处理器的级别匹配，则直接进行处理。
            handle(request);
        } else {
            if (null != nextHandler) {
                System.out.println("this Handler can not handle this request send to nextHandler");
                nextHandler.handleRequest(request);
            } else {
                System.out.println("All the AbsHandler can not handle this request");
            }
        }
    }

    /**
     * 待实现的处理方法
     *
     * @param request
     */
    protected abstract void handle(AbstractRequest request);

    /**
     * 获取处理对象的处理级别
     *
     * @return
     */
    private RequestLevel getHandlerLevel() {
        return this.level;
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
