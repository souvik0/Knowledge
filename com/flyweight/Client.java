package com.flyweight;

public class Client {

    public static void main (String[] args) {
        Pen yellowThickPen = PensFactory.getThickPen("Yellow");
        yellowThickPen.draw();

        Pen blueThickPen = PensFactory.getThinPen("Blue");
        blueThickPen.draw();
    }
}
