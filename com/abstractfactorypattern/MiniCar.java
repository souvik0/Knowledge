package com.abstractfactorypattern;

public class MiniCar extends Car {

    public MiniCar(Location location) {
        super(CarType.MINI, location);
    }

    @Override
    public void construct() {
        System.out.println("Constructing to Mini Car from car factory at: " + location.toString());
    }
}
