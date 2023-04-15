package com.java8.ksm;

import java.util.Optional;

public class Person {
    private int id;
    private String name;
    private boolean isAdult;

    private Person friend;

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

    // null 이 반환될 수 있는 경우에, Optional 로 감싸서 반환.
    public Optional<Person> getFriend() {
        return Optional.ofNullable(friend);
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }
}
