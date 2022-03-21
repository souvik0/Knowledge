package tinyURL;

public class TinyURLTester {

    public static void main(String[] args) {
        TinyURLConverter tinyURLConverter = new TinyURLConverter();
        System.out.println(tinyURLConverter.convertToShortUrl((long) 98765781, "https://google.com"));
        System.out.println(tinyURLConverter.convertToLongUrl("http://tinyurl.com/006gPUT"));
    }
}
