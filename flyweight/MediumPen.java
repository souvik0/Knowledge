package com.flyweight;

public class MediumPen implements Pen {

    String brushSize = BrushSize.MEDIUM.toString();
    String color = null;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
    	System.out.println("Drawing with " + color + " " + brushSize +"pen");
    }
}
