package com.frewen.designpattern.chain.resposibility.sample;

public abstract class Leader {

    protected Leader nextHandler;

    public final void HandleRequest(int money) {
        if (money <= maxLimit()) {
            handle(money);
        } else {
            System.out.println(getClass().getSimpleName() + "无法处理" + money + "元的报销，交给上级来处理");
            if (null != nextHandler) {
                nextHandler.HandleRequest(money);
            } else {
                System.out.println("no Leader can handle this money");
            }
        }
    }

    /**
     * 领导处理这个数额额报销
     *
     * @param money
     */
    protected abstract void handle(int money);

    /**
     * 此领导最高可处理的额度
     *
     * @return
     */
    protected abstract int maxLimit();
}
