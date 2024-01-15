package me.sjl;

import me.sjl.spi.Fruit;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ServiceLoader<Fruit> load = ServiceLoader.load(Fruit.class);
        Iterator<Fruit> iterator = load.iterator();
        while (iterator.hasNext()) {
            Fruit fruit = iterator.next();
            String name = fruit.getName();
            System.out.println(name);
        }
    }
}