package com.frewen.reflect;

public class Cat {

    private String name;
    @Deprecated
    public int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void eat(String food) {
        System.out.println("eat called food = [" + food + "]");
    }

    public void eat(String... foods) {
        StringBuilder s = new StringBuilder();
        for (String food : foods) {
            s.append(food);
            s.append(" ");
        }
        System.out.println("eat called foods = [" + foods + "]");
    }

    public void sleep() {
        System.out.println("sleep called");
    }

    @Override
    public String toString() {
        return "name = " + name + " age = " + age;
    }
}