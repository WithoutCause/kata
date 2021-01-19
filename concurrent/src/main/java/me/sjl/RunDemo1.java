package me.sjl;

import java.util.Random;

public class RunDemo1 implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println(new Random().nextInt());
        }
    }
}
