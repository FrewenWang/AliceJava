package com.frewen.designpattern.mediator.sample;

public class Buyer extends Customer {

    public Buyer(String name) {
        super(name);
        ClientWindow(50, 100);
    }

    @Override
    public void send(String ad) {
        ReceiveArea.append("我(买方)说: " + ad + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
        medium.relay(name, ad);
    }

    @Override
    public void receive(String from, String ad) {
        ReceiveArea.append(from + "说: " + ad + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
    }
}
