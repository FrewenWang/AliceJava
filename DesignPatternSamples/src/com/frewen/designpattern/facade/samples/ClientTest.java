package com.frewen.designpattern.facade;

public class ClientTest {

    public static void main(String[] args) {
        MobilePhoneWrapper mobilePhone = new MobilePhoneWrapper();
        mobilePhone.dial();

        mobilePhone.videoChat();
    }

}
