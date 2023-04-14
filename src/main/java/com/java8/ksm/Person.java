package com.java8.ksm;

public class Person {
    private int id;
    private String name;
    private boolean isAdult;

    public Person(int id, String name, boolean isAdult) {
        this.id = id;
        this.name = name;
        this.isAdult = isAdult;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAdult() {
        return isAdult;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isAdult=" + isAdult +
                '}';
    }
}
