package com.builderpattern;

public class Client {

    public static void main (String[] args) {
        ComputerBuilderDecorator computerBuilderDecorator = new ComputerBuilderDecorator();
        System.out.println(computerBuilderDecorator.displayTypeBasedComputer(DisplayType.LED).getDisplayType().toString());
    }
}