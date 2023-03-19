package com.abstractfactorypattern;

public class AbstractFactoryClient {

    public static void main(String[] args) {
        CarFactory.constructCar(CarType.MICRO, Location.INDIA).construct();
        CarFactory.constructCar(CarType.MINI,Location.USA).construct();
        CarFactory.constructCar(CarType.LUXURY, Location.USA).construct();
    }
}
