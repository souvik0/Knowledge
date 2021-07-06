package com.factoryPattern;

public class Sedan extends Car{

    public Sedan(CarType model) {
        super(model);
    }

    public void construct() {
        System.out.println("Contructing Sedan");
    }
}
