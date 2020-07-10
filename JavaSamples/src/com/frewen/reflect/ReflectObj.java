package com.frewen.reflect;

public class ReflectObj {

    public ReflectObj() {
        System.out.println("ReflectObj constructor called");
    }

    public ReflectObj(int id) {
        this.id = id;
        System.out.println("ReflectObj constructor called with id=" + id);
    }

    public ReflectObj(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("ReflectObj constructor called with id = " + id + ",name = " + name);
    }


    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReflectObj id:" + id + ",name:" + name;
    }

}
