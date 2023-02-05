package com.abstractfactorypattern;

public class LuxuryCar extends Car {

    public LuxuryCar(Location location) {
        super(CarType.LUXURY, location);
    }

    @Override
    public void construct() {
        System.out.println("Constructing to luxury car");
    }
}
