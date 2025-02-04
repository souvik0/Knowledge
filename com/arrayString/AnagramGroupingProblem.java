package com.arrayString;

/*  Any kind of grouping of objects can be done easily with hashing algorithm
    Here ascii is taken into consideration to identify key of the hashing 
    algorithm to group the strings.
    topView, bottomView & verticalView of BT/BST problems are also falling 
    under the same category
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGroupingProblem {

    public static void main(String[] args) {
       String[] strArr = {"eat","tea","tan","ate","nat","bat","tab","abt"};
       findAnagramGroup(strArr);
    }

    //Common property between words are ascii
    public static int stringToAscii(String str) {
        int stringAscii = 0;

        for (int i = 0; i < str.length(); i++) {
             int ascii = (int) str.charAt(i);
             stringAscii = stringAscii + ascii;
        }

        return stringAscii;
    }

    public static void findAnagramGroup(String[] strArr) {
        // This map contains ascii value of the Strings as Key & List of strings having same ascii as value
        Map<Integer, List<String>> anagramMap = new HashMap<Integer, List<String>>();

        for (int i = 0; i < strArr.length; i++) {
             int ascii = stringToAscii(strArr[i]);
             if (anagramMap.size() != 0 && anagramMap.containsKey(ascii)) {
                 List<String> anagramList = anagramMap.get(ascii);
                 anagramList.add(strArr[i]);
                 anagramMap.put(ascii, anagramList);
             } else {
                 List<String> anagramList = new ArrayList<String>();
                 anagramList.add(strArr[i]);
                 anagramMap.put(ascii, anagramList);
             }
        }

        for (Map.Entry<Integer, List<String>> entry: anagramMap.entrySet()) {
             System.out.print(entry.getKey() + " : ");
             System.out.println(entry.getValue().toString());
        }
    }
}
