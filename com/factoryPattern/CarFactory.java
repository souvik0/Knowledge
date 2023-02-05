package com.factoryPattern;

public class CarFactory {

     public static Car buildCar(CarType model) {
         Car car = null;
         switch(model) {
         case SUV:
             car = new SUV(model);
             break;

         case SEDAN:
             car = new Sedan(model);
             break;

         case HATCHBACK:
             car = new HatchBack(model);
             break;
         }

         return car;
     }
}