package com.abstractfactorypattern;

public class CarFactory {

    public static Car constructCar(CarType model, Location location) {
        Car car = null;
        switch(location) {
            case USA:
                car = USACarFactory.buildCar(model);
                break;
            case INDIA:
                car = INDIACarFactory.buildCar(model);
                break;
            default:
                car = DefaultCarFactory.buildCar(model);
        }
        return car;
    }
}
