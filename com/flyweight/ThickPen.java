package com.flyweight;

public class ThickPen implements Pen {

    String brushSize = BrushSize.THICK.toString(); //Intrinsic shareable property
    String color = null; // Extrinsic non-shareable property

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing with " + color + " " + brushSize + " pen");
    }
}
