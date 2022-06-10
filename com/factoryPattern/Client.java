package com.factoryPattern;

public class Client {

    public static void main(String[] args) {
        CarFactory.buildCar(CarType.HATCHBACK).construct();
        CarFactory.buildCar(CarType.SEDAN).construct();
        CarFactory.buildCar(CarType.SUV).construct();
    }
}