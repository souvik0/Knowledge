package com.abstractfactorypattern;

public enum CarType {

    MICRO("MICRO"), 
    MINI("MINI"), 
    LUXURY("LUXURY");

    private final String carType;

    CarType(String carType) {
        this.carType = carType;
    }

    public String toString() {
        return carType;
    }
}
