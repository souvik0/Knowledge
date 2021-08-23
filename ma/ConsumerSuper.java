package ma;

import java.util.ArrayList;
import java.util.List;

public class ConsumerSuper {

    public static void main(String[] args) {
        //List of apples
        List<Apple> applesList = new ArrayList<Apple>();
        applesList.add(new Apple());

        List<Fruit> fruitList = new ArrayList<Fruit>();
        fruitList.add(new Fruit());

        List<AsianApple> asianAppleList = new ArrayList<AsianApple>();
        asianAppleList.add(new AsianApple());

       //We can assign a list of apples to a basket of apples
       List<? super Apple> basket = applesList;
       List<? super Apple> fruitBasket = fruitList;
       List<? super Apple> asianAppleBasket = asianAppleList; // Compile time error because sub type can't assigned to super

       // Can consume same or sub-type
       basket.add(new Apple());
       basket.add(new AsianApple());
       basket.add(new Mango()); // compile time error because of disjointed type
       basket.add(new Fruit()); // Compile time error
    }
}
