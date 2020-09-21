package com.frewen.designpattern.facade;

/**
 * 移动手机作为对外接口类
 */
public class MobilePhoneWrapper {

    private IPhone phone = new SumsunPhone();
    private ICamera sumsunCamera = new SumsunCamera();

    public void dial() {
        phone.dial();
    }

    public void videoChat() {
        System.out.println("视频通话中。。。。。");
        sumsunCamera.open();
        phone.dial();

    }

    public void hangup() {
        phone.hangup();
    }

}
