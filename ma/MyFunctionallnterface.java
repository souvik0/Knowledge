package ma;

@FunctionalInterface
public interface MyFunctionallnterface {

    // Single abstract method
    public void display(String name);

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