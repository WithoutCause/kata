package me.sjl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 2, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));
        executor.submit(() -> {
            System.out.println("hello world1");
        });
        executor.submit(() -> {
            System.out.println("hello world2");
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
