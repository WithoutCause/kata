package me.sjl;

public class ThreadTest {

    public static void main(String[] args) {
        Thread t = new Thread(new RunDemo1());
        t.start();
    }

}
