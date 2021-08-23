package factoryPattern;

public enum CarType {

    SUV("SUV"), 
    SEDAN("SEDAN"), 
    HATCHBACK("HATCHBACK");

    private final String carType;

    CarType(String carType) {
        this.carType = carType;
    }

    public String toString() {
        return carType;
    }
}