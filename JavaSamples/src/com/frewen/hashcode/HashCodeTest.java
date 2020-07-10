package com.frewen.hashcode;

import java.util.HashMap;
import java.util.Objects;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}

public class HashCodeTest {

    public static void main(String[] args) {

        Student p1 = new Student("Jack", 12);
        System.out.println(p1.hashCode());

        HashMap<Student, Integer> hashMap = new HashMap<Student, Integer>();
        hashMap.put(p1, 1);

        System.out.println(hashMap.get(new Student("Jack", 12)));
    }

}
