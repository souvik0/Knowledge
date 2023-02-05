package com.abstractfactorypattern;

public enum Location {

    INDIA("INDIA"), 
    USA("USA"), 
    DEFAULT("DEFAULT");

    private final String location;

    Location(String location) {
        this.location = location;
    }

    public String toString() {
        return location;
    }
}
