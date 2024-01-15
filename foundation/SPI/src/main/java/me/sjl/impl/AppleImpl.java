package me.sjl.impl;

import me.sjl.spi.Fruit;

public class AppleImpl implements Fruit {


    @Override
    public String getName() {
        return "this is apple";
    }
}
