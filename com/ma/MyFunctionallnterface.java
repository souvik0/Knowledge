package com.ma;

@FunctionalInterface
public interface MyFunctionallnterface<T> {

    // Single abstract method
    public void display(T name);

    public default void move(){
        System.out.println("I am moving");
    }

    public static void moveAgain() {
        System.out.println("Moving again");
    }

    // Another abstract method which overrides public method of object class.
    @Override
    public String toString();
}