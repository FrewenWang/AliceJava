package com.frewen.designpattern.memento;

public class Memeto {
    public int mCheckPoint;
    public int mLifeValue;
    public String mWeapon;

    @Override
    public String toString() {
        return "Memeto{" +
                "mCheckPoint=" + mCheckPoint +
                ", mLifeValue=" + mLifeValue +
                ", mWeapon='" + mWeapon + '\'' +
                '}';
    }
}
