package com.frewen.enumdemo;

public enum Colors {

    RED(0, "red", "红色"),
    WHITE(0, "white", "白色"),
    BLUE(0, "blue", "蓝色");


    private final int value;
    private final String enName;
    private final String chName;

    Colors(int value, String enName, String chName) {
        this.value = value;
        this.enName = enName;
        this.chName = chName;
    }

    public String getChName() {
        return this.chName;
    }

}
