package me.sjl.impl;

import me.sjl.spi.Fruit;

public class Orange implements Fruit {

    @Override
    public String getName() {
        return "this is orange";
    }
}
