package com.ma;

import java.util.ArrayList;
import java.util.List;

public class ProducerExtends {

    public static void main(String[] args) {

        List<Fruit> fruitList = new ArrayList<Fruit>();
        fruitList.add(new Fruit());
        //List of apples
        List<Apple> applesList = new ArrayList<Apple>();
        applesList.add(new Apple());

        List<AsianApple> asianAppleList = new ArrayList<AsianApple>();
        asianAppleList.add(new AsianApple());

        //We can assign a list of apples to a basket of fruits;
        //because apple is subtype of fruit
        //Narrowing the scope or covariance the scope
        List<? extends Fruit> appleBasket = applesList; // Any sub type of Fruit can be assigned
        List<? extends Fruit> asianAppleBasket1 = asianAppleList;
        List<? extends Apple> asianAppleBasket2 = asianAppleList; // Any sub type of Apple can be assigned
        List<? extends Apple> fruitBasket = fruitList;
        List<? extends Apple> appleBasket1 = applesList;

        appleBasket.add(new Apple()); //Compile time error
        appleBasket.add(new AsianApple());
        fruitBasket.add(new Mango());
        appleBasket.add(new Fruit()); //Compile time error

        appleBasket.add(new Apple());
        appleBasket.add(new Fruit());

        asianAppleBasket1.add(new AsianApple());
        asianAppleBasket2.add(new Apple());
        asianAppleBasket1.add(new Fruit());
    }
}
