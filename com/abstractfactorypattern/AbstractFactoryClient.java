package com.abstractfactorypattern;

/* This represents one by one invocation of families of objects, where
 * invocation of 2nd family depends on the invocation of 1st family objects
 */

public class AbstractFactoryClient {

    public static void main(String[] args) {
        CarFactory.constructCar(CarType.MICRO, Location.INDIA).construct();
        CarFactory.constructCar(CarType.MINI,Location.USA).construct();
        CarFactory.constructCar(CarType.LUXURY, Location.USA).construct();
    }
}
