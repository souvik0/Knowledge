package arrayString;

// Here string is getting split maximum in 3 parts where every part must contain 'a'
// Objective is to find out how many ways we can achieve the above

public class SplitString {

    public static int splitString(String S) {
        int stringLength = S.length();
        int aCount = 0;
        int firstDivision = 0;
        int secondDivision = 0;
        int counter = 0;

        if (S == null || S.length() == 0) {
            return 0;
        }

        for (int i = 0; i < stringLength; i++) {
            if (S.charAt(i) == 'a') {
                aCount++;
            }
        }

        // String isn't divisible in 3 parts
        if (aCount % 3 != 0) {
            return 0;
        }

        if (aCount == 0) {
            return ((stringLength - 1) * (stringLength - 2)) / 2;
        }

        // Here equally distributing a in substring
        int aInEachSubstring = aCount / 3;

        for (int j = 0; j < stringLength; j++) {
            if (S.charAt(j) == 'a') {
                counter++;
            }
            if (counter == aInEachSubstring) {
                firstDivision++;
            }
            else if (counter == 2 * aInEachSubstring) {
                secondDivision++;
            }
        }

        return firstDivision * secondDivision;
    }

    public static void main(String[] args) {
        String s = "ababa";
        // Function Call
        System.out.println("The number of " + 
                           "ways to split is " +
                           splitString(s));
    }
}