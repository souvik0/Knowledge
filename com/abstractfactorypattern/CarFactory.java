package com.abstractfactorypattern;

public class CarFactory {

    public static Car buildCar(CarType model) {
        Car car = null;
        Location location = Location.INDIA;
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
