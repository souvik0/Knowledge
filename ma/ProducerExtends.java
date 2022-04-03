package ma;

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
        ///Narrowing the scope or covariance the scope
        List<? extends Fruit> basket = applesList; // Any sub type of Fruit can be assigned
        List<? extends Fruit> asianBasket = asianAppleList;
        List<? extends Apple> asianAppleBasket = asianAppleList; // Any sub type of Apple can be assigned
        List<? extends Apple> fruitBasket = fruitList;
        List<? extends Apple> appleBasket = applesList;

        appleBasket.add(new Apple()); //Compile time error
        appleBasket.add(new AsianApple());
        appleBasket.add(new Mango());
        appleBasket.add(new Fruit()); //Compile time error

        basket.add(new Apple());
        basket.add(new Fruit());

        asianAppleBasket.add(new AsianApple());
        asianAppleBasket.add(new Apple());
        asianAppleBasket.add(new Fruit());
    }
}
