package com.ethan.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalNormalUsage06 {
    public static void main(String[] args) {
        new Service1().process();
    }
}

class UserContextHolder {
    public static ThreadLocal<User> userHolder = new ThreadLocal<>();
}

class Service1 {
    public void process() {
        User user = new User("zhuyuchen");
        UserContextHolder.userHolder.set(user);
        new Service2().process();
    }
}

class Service2 {
    public void process() {
        User user = UserContextHolder.userHolder.get();
        System.out.println("Service2:"+user);
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        User user = UserContextHolder.userHolder.get();
        System.out.println("Service3:"+user);
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
