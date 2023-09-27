package com.arrayString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount {

    public static void main(String[] args) {
        String[] domains = {"900, google.com",
                           "60, mail.yahoo.com", 
                           "10, mobile.sports.yahoo.com",
                           "40, sports.yahoo.com",
                           "300, yahoo.com",
                           "10, stackoverflow.com",
                           "20, overflow.com",
                           "5, com.com",
                           "2, en.wikipedia.org",
                           "1, m.wikipedia.org",
                           "1, mobile.sports",
                           "1, google.co.uk"};

        List<String> domainCountList = printSubDomainCount(domains);
        for (String subDomainCount : domainCountList) {
             System.out.println(subDomainCount);
        }
    }

    public static List<String> printSubDomainCount(String[] domains) {
        Map<String, Integer> subDomainVisitCountMap = new HashMap<String, Integer>();
        List<String> subDomainCountList = new ArrayList<String>();

        for (String domain : domains) {
             String[] domainCountArray = domain.split(",");
             int visitCount = Integer.parseInt(domainCountArray[0]); 
             String[] subDomains = domainCountArray[1].split("\\.");
             StringBuilder sb = new StringBuilder();

             for (int i = subDomains.length -1 ; i >= 0; i--) {
                  // Data are getting inserted from the last
                  if (i == subDomains.length -1) {
                      sb.append(subDomains[i]);
                  } else {
                      // insert at same position is equivalent to consistently adding at 
                      // the first position or continuous append
                      sb.insert(0, ".");
                      sb.insert(0, subDomains[i]);
                  }

                  String subDomain = sb.toString();
                  if (subDomainVisitCountMap.containsKey(subDomain)) {
                      subDomainVisitCountMap.put(subDomain,
                                             visitCount + subDomainVisitCountMap.get(subDomain));
                  } else {
                      subDomainVisitCountMap.put(subDomain, visitCount);
                  }
             }
        }

        for (String subDomain : subDomainVisitCountMap.keySet()) {
            StringBuilder subDomainResult = new StringBuilder();
            subDomainResult.append(subDomainVisitCountMap.get(subDomain));
            subDomainResult.append(" ");
            subDomainResult.append(subDomain);
            subDomainCountList.add(subDomainResult.toString());
        }

        return subDomainCountList;
    }
}
