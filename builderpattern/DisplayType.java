package builderpattern;

public enum DisplayType {

    LED("LED"),
    LCD("LCD");

    private final String displayType;

    DisplayType (String displayType) {
        this.displayType = displayType;
    }

    public String toString () {
        return displayType;
    }
}
