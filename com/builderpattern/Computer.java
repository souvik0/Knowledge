package com.builderpattern;

/* Builder pattern creates immutable objects with large set of state parameters.
 * So,there will not be any setter method.
 * Separate the construction of a complex object from its representation so that the
 * same construction process can create different representation.
 * It creates objects always with complete state
 */
public final class Computer {

    // Mandatory Properties
    private final String RAM;
    private final String ROM;
    private final String HDD;

    // Optional Properties
    private final boolean isGraphicsEnabled;
    private final DisplayType displayType;

    // Private constructor should be present, so that it can't be invoked from outside
    private Computer(ComputerBuilder builder) {
         this.RAM = builder.RAM;
         this.ROM = builder.ROM;
         this.HDD = builder.HDD;
         this.displayType = builder.displayType;
         this.isGraphicsEnabled = builder.isGraphicsEnabled;
    }

    public String getRAM() {
        return RAM;
    }

    public String getROM() {
        return ROM;
    }

    public String getHDD() {
        return HDD;
    }

    public boolean isGraphicsEnabled() {
        return isGraphicsEnabled;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public static class ComputerBuilder {
        // Mandatory Properties
        public String RAM;
        public String ROM;
        public String HDD;

        // Optional Properties
        public boolean isGraphicsEnabled;
        public DisplayType displayType;

        // This constructor create objects with mandatory properties
        public ComputerBuilder(String RAM, String ROM, String HDD) {
            this.RAM = RAM;
            this.ROM = ROM;
            this.HDD = HDD;
        }

        public ComputerBuilder setGraphicsEnabled(boolean isGraphicsEnabled) {
            this.isGraphicsEnabled = isGraphicsEnabled;
            return this;
        }

        public ComputerBuilder setDisplayType(DisplayType displayType) {
            this.displayType = displayType;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}