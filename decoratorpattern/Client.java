package com.decoratorpattern;

public class Client {

	public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        // Adding red border is additional functionality added at runtime
        Shape redBorderCircle = new RedShapeDecorator (new Circle());  
        redBorderCircle.draw();
        // Adding green border is additional functionality added at runtime
        Shape greenBorderCircle = new GreenShapeDecorator (new Circle());
        greenBorderCircle.draw();

        Shape rectangle = new Rectangle();
        rectangle.draw();
        Shape redBorderRectangle = new RedShapeDecorator (new Rectangle());
        redBorderRectangle.draw();
        Shape greenBorderRectangle = new GreenShapeDecorator (new Rectangle());
        greenBorderRectangle.draw();
    }
}
