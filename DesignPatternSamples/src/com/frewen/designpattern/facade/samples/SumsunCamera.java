package com.frewen.designpattern.facade.samples;

public class SumsunCamera implements ICamera {

    @Override
    public void open() {
        System.out.println("打开相机！！");
    }

    @Override
    public void takePicture() {
        System.out.println("拍摄照片！！！");
    }

    @Override
    public void close() {
        System.out.println("关闭相机！！！");
    }
}
