package jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheadBusy {

    public static void createBusyThead() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(1);
                }
            }
        }, "testBusyThread");

        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThead();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
