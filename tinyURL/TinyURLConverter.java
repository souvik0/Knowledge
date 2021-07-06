package com.tinyURL;

import java.util.HashMap;
import java.util.Map;

public class TinyURLConverter {

    public Map<Long, String> counterToLongUrl = new HashMap<Long, String>();
    public Map<String, Long> longUrlToCounter = new HashMap<String, Long>();
    String base62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String convertToShortUrl(Long counter, String longUrl) {
        if (longUrlToCounter.containsKey(longUrl)) {
            return "http://tinyurl.com/" + base62Encode(longUrlToCounter.get(longUrl));
        } else {
        	counterToLongUrl.put(counter, longUrl);
            longUrlToCounter.put(longUrl, counter);
            return "http://tinyurl.com/" + base62Encode(longUrlToCounter.get(longUrl));
        }
    }

    public String convertToLongUrl (String shortUrl) {
        // Choosing lastIndex because encoded shortURL value present at last
        String base62EncodedValue = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        return counterToLongUrl.get(base62decode(base62EncodedValue));
    }

    public String base62Encode(Long counterValue) {
        StringBuilder base62EncodedString = new StringBuilder();
        while (counterValue != 0) {
            base62EncodedString.append(base62.charAt((int)(counterValue % 62)));
            counterValue = counterValue / 62;
        }
        while (base62EncodedString.length() < 7) {
        	base62EncodedString.append(0);
        }
        return base62EncodedString.reverse().toString();
    }

    public long base62decode(String base62EncodedValue) {
        long decode = 0;
        for (int i =0 ; i < base62EncodedValue.length(); i++) {
            decode = decode*62 + base62.indexOf(base62EncodedValue.charAt(i));
        }
        return decode;
    }
}
