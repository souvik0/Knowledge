package com.factoryPattern;

public class SUV extends Car {

    public SUV (CarType model) {
         super(model);
    }

    public void construct () {
        System.out.println("Contructing SUV");
    }
}
