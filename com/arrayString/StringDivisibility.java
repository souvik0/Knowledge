package com.arrayString;

// This problem tries to figure out how many divisors present between two strings
public class StringDivisibility {

    public static int findSmallestDivisor(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
           return -1;
        }

        // If they're not divisible return -1
        if (s.length() % t.length() != 0) {
            return -1;
        }

        // Check for repeat. 
        //There must be at least one concatenation to get the divisbility successful.
        int l2 = t.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i % l2))
                return -1;
        }

        for (int i = 0; i < t.length(); i++) {
             int j;
             for (j = 0 ; j < t.length(); j++) {
                  if (t.charAt(j) != t.charAt(j % (i+1)))
                      break;
             }
            if (j == t.length()) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "bcdbcdbcd", s2 = "bcdbcd";
        String s3 = "bcdbcdbcdbcd", s4 = "bcdbcd";
        String s5 = "aaaaaa", s6 = "a";
        String s7 = "wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzg"
                    + "gijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcys"
                    + "ulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxm"
                    + "mthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnja"
                    + "zdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkd"
                    + "nzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcy"
                    + "sulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmm"
                    + "thrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdw"
                    + "qzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggi"
                    + "jhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydc"
                    + "sbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdc"
                    + "vrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuog"
                    + "sqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwq"
                    + "yrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzog"
                    + "ewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvz"
                    + "gmtzeijkzixtfxhrqpllspijwnsitnjazd";
        String s8 = "wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdn"
                    + "daebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzi"
                    + "xtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrn"
                    + "ejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmt"
                    + "hrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd";

        //System.out.println(findSmallestDivisor(s1, s2));
        System.out.println(findSmallestDivisor(s3, s4));
        //System.out.println(findSmallestDivisor(s5, s6));
        //System.out.println(findSmallestDivisor(s7, s8));
    }

    public static int solution(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return -1;
        }

        // If they're not divisible return -1
        if (s.length() % t.length() != 0) {
            return -1;
        }

        // Check for repeat
        //There must be at least one concatenation to get the divisbility successful.
        int l2 = t.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i % l2))
               return -1;
        }

        return count(t);
    }

    public static int count(String t) {
        if (t.substring(0, t.length()/2).contentEquals(t.substring(t.length()/2, t.length()))) {
            return count(t.substring(0, t.length()/2));
        } else {
            return t.length();
        }
    }
}
