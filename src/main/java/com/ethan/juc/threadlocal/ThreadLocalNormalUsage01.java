package com.ethan.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalNormalUsage01 {
    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                String date = new ThreadLocalNormalUsage01().date(10+ finalI);
                System.out.println(date);
            }).start();
            Thread.sleep(100);
        }
    }
}
