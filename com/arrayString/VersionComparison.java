package com.arrayString;

public class VersionComparison {

    public static void main(String[] args) {
        String version1 = "1.2.6";
        String version2 = "1.2.4";
        int result = compareVersions(version1, version2);

        if (result < 0) {
            System.out.println(version1 + " is less than " + version2);
        } else if (result > 0) {
            System.out.println(version1 + " is greater than " + version2);
        } else {
            System.out.println(version1 + " is equal to " + version2);
        }
    }

    public static int compareVersions(String version1, String version2) {
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");

        int maxLength = Math.max(versionArray1.length, versionArray2.length);

        for (int i = 0; i < maxLength; i++) {
            int num1 = i < versionArray1.length ? Integer.parseInt(versionArray1[i]) : 0;
            int num2 = i < versionArray2.length ? Integer.parseInt(versionArray2[i]) : 0;

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }

        return 0; // Both versions are equal
    }
}
