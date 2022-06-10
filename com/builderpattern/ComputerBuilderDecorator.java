package com.builderpattern;

public class ComputerBuilderDecorator {

    public Computer getBasicComputer() {
        return new Computer.ComputerBuilder("8", "1024", "SATA")
                           .build();
    }

    public Computer graphicsEnabledComputer() {
        return new Computer.ComputerBuilder("8", "1024", "SATA")
                           .setGraphicsEnabled(true)
                           .build();
    }

    public Computer displayTypeBasedComputer(DisplayType displayType) {
        return new Computer.ComputerBuilder("8", "1024", "SATA")
                           .setDisplayType(displayType)
                           .build();
    }

    public Computer allConfigComupter(DisplayType displayType) {
        return new Computer.ComputerBuilder("10", "1024", "ATA")
                           .setGraphicsEnabled(true)
                           .setDisplayType(displayType)
                           .build();
    }
}
