package com.abstractfactorypattern;

public class MicroCar extends Car {

    public MicroCar(Location location) {
       super(CarType.MICRO, location);
    }

    @Override
    public void construct() {
        System.out.println("Constructing to Micro Car");
    }
}
