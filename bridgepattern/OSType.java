package bridgepattern;

public enum OSType {

    WINDOWS("WINDOWS"),
    LINUX("LINUX"),
    MAC("MAC");

    private final String osType;

    OSType(String osType) {
        this.osType = osType;
    }

    public String toString() {
        return osType;
    }
}