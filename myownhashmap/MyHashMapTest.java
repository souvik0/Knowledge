package myownhashmap;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyHashMapTest {

    @Test
    public void readWriteSimpleValue() {
        MyHashMap<String, Duck> map = new MyHashMap<String, Duck>();
        map.put("duck", new Duck("duck",2));
        map.put("goose", new Duck("goose",4));
        assertEquals(2, map.get("duck").getWeight());
        assertEquals(4, map.get("goose").getWeight());
    }

    @Test
    public void getSomethingThatIsntThere() {
        MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
        assertEquals(null, map.get(42));
    }

    @Test
    public void overWriteValue() {
        MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
        map.put(42, "meh");
        assertEquals("meh", map.get(42));
        map.put(42, "we have the technology to rebuild him");
        assertEquals("we have the technology to rebuild him", map.get(42));
    }

    /**
    * A simple Util class
    **/
    class Duck {
        private String name;
        private int weight;
        public Duck(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }
    }
}
