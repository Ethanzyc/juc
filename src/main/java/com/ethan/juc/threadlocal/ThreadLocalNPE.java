package com.ethan.juc.threadlocal;

public class ThreadLocalNPE {
    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();

    public void set() {
        longThreadLocal.set(Thread.currentThread().getId());
    }

    public long get() {
        return longThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalNPE threadLocalNPE = new ThreadLocalNPE();
        new Thread(() -> {
            threadLocalNPE.set();
            System.out.println(threadLocalNPE.get());
        }).start();
    }
}
