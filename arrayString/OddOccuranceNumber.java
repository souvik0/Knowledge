package arrayString;

// This program will also cater majority problem, where occurance of an element is more than n/2
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class OddOccuranceNumber {

    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        oddOccurance(arr);
    }

    public static void oddOccurance (int[] arr) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
             if (hmap.containsKey(arr[i])) {
                 hmap.put(arr[i], hmap.get(arr[i]) + 1);
             } else {
                 hmap.put(arr[i], 1);
             }
        }

        Iterator<Entry<Integer, Integer>> itr = hmap.entrySet().iterator();

        while (itr.hasNext()) {
            Entry<Integer, Integer> entry = (Entry<Integer, Integer>) itr.next();
            if (entry.getValue() % 2 == 1) {
                 System.out.println("Key: " + entry.getKey());
            }
        }
    }
}