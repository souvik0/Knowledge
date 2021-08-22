package arrayString;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        String str = "babelal";
        System.out.println(permute(str, 0, str.length(), strList).toString());
    }

    public static List<String> permute(String str, int left, int right, List<String> strList) {
        // This is recursion terminating condition
        if (left == right - 1) {
            strList.add(str);
        }

        for (int i = left; i < right; i++) {
            str = swapString(str, left, i);
            permute(str, left + 1, right, strList);
            // Backtracking of string
            str = swapString(str, left, i);
        }

        return strList;
    }

    public static String swapString(String str, int i, int j) {
        char[] b = str.toCharArray();
        char temp = b[i];
        b[i] = b[j];
        b[j] = temp;
        return String.valueOf(b);
    }
}
