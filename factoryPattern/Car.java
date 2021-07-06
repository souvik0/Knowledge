package com.factoryPattern;

// It can be interface also
public abstract class Car {

    public CarType model;

    public Car(CarType model) {
       this.model = model;
    }

    // abstract method to be implemented by subclasses
    public abstract void construct();

    public CarType getModel() {
        return model;
    }
}