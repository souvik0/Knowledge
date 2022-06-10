package com.flyweight;

public enum BrushSize {

    THICK("Thick"),
    THIN("Thin"),
    MEDIUM("Medium");

    private final String brushSize;

    BrushSize(String brushSize) {
        this.brushSize = brushSize;
    }

    public String toString () {
        return brushSize;
    }
}
