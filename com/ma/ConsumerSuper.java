package com.ma;
// Using during method invocation is the most common use case.
import java.util.ArrayList;
import java.util.List;

public class ConsumerSuper {

    public static void main(String[] args) {

        List<Fruit> fruitList = new ArrayList<Fruit>();
        fruitList.add(new Fruit());

        //List of apples
        List<Apple> applesList = new ArrayList<Apple>();
        applesList.add(new Apple());

        List<AsianApple> asianAppleList = new ArrayList<AsianApple>();
        asianAppleList.add(new AsianApple());

       // We can assign a list of apples to a basket of apples
       // Widening the scope or Contra-variance the scope
       List<? super Apple> appleBasket = applesList;
       List<? super Apple> fruitBasket = fruitList;
       List<? super Apple> asianAppleBasket = asianAppleList; // Compile time error because sub type can't assigned to super

       // Can consume same or sub-type
       appleBasket.add(new Apple());
       appleBasket.add(new AsianApple());
       appleBasket.add(new Mango()); // compile time error because of disjointed type
       appleBasket.add(new Fruit()); // compile time error
    }
}
