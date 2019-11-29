package com.tacbin.starter;

/**
 * Description
 * Author liuweibin
 * Date 2019/11/29 15:01
 **/
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name : " + name + " age : " + age;
    }
}
