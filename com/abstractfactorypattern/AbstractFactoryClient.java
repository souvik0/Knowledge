package com.abstractfactorypattern;

public class AbstractFactoryClient {

    public static void main(String[] args) {
        CarFactory.buildCar(CarType.MICRO).construct();
        CarFactory.buildCar(CarType.MINI).construct();
        CarFactory.buildCar(CarType.LUXURY).construct();
    }
}
