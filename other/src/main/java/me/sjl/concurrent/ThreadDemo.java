package me.sjl.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadDemo implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println(Math.random());
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread t = new Thread(threadDemo);
        t.setName("zhangsan");
        t.start();
    }
}
