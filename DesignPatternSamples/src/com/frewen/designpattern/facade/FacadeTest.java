package com.frewen.designpattern.facade;

public class FacadeTest {

    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.dial();

        mobilePhone.videoChat();
    }

}
