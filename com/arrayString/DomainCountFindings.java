package com.arrayString;

import java.util.Map;
import java.util.TreeMap;

public class DomainCountFindings {

    public static void main(String[] args) {
        String[] counts = {"900,google.com",
                           "60,mail.yahoo.com",
                           "10,mobile.sports.yahoo.com",
                           "40,sports.yahoo.com",
                           "300,yahoo.com",
                           "10,stackoverflow.com",
                           "20,overflow.com",
                           "5,com.com",
                           "2,en.wikipedia.org",
                           "1,m.wikipedia.org",
                           "1,mobile.sports",
                           "1,google.co.uk"};

        Map<String, Integer> domainCountMap = printDomainCount(counts);
        for (Map.Entry<String, Integer> entry : domainCountMap.entrySet()) {
              System.out.println(entry.getKey());
              System.out.println(entry.getValue());
        }
    }

    public static Map<String, Integer> printDomainCount(String[] counts) {
        Map<String, Integer> domainCountMap = new TreeMap<String, Integer>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i].contains(",")) {
                int splitIndex = counts[i].indexOf(",");
                int count = Integer.parseInt(counts[i].substring(0, splitIndex));
                String domain = counts[i].substring(splitIndex + 1);
                if (!domainCountMap.containsKey(domain)) {
                    domainCountMap.put(domain, count);
                    String[] strArr = domain.split("[.]", 0);
                    for (int j = 0; j < strArr.length; j++) {
                         if (!domainCountMap.containsKey(strArr[j])) {
                             domainCountMap.put(strArr[j], count);
                        } else {
                             domainCountMap.put(strArr[j], domainCountMap.get(strArr[j]) + count);
                        }
                    }
                } else {
                     domainCountMap.put(domain, domainCountMap.get(domain) + count);
                }
            }
        }
        return domainCountMap;
    }
}
