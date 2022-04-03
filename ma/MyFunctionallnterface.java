package ma;

@FunctionalInterface
public interface MyFunctionallnterface<T> {

    // Single abstract method
    public void display(T name);

    default void move(){
        System.out.println("I am moving");
    }

    static void moveAgain() {
        System.out.println("Moving again");
    }

    // Another abstract method which overrides public method of object class.
    @Override
    public String toString();
}