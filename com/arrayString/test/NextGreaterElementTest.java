package com.arrayString.test;

import org.junit.jupiter.api.Test;
import com.arrayString.NextGreaterElementFromArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NextGreaterElementTest {

    @Test
    public void testFindNextGreaterElement() {
        // Test case: Example input [4, 5, 2, 25]
        int[] input1 = {4, 5, 2, 25};
        int[] expectedOutput1 = {5, 25, 25, -1};
        assertArrayEquals(expectedOutput1, NextGreaterElementFromArray.findNextGreaterElement(input1));

        // Test case: Example input [13, 7, 6, 12]
        int[] input2 = {13, 7, 6, 12};
        int[] expectedOutput2 = {-1, 12, 12, -1};
        assertArrayEquals(expectedOutput2, NextGreaterElementFromArray.findNextGreaterElement(input2));

        // Test case: Example input [4, 6, 3, 2, 8, 1]
        int[] input3 = {4, 6, 3, 2, 8, 1};
        int[] expectedOutput3 = {6, 8, 8, 8, -1, -1};
        assertArrayEquals(expectedOutput3, NextGreaterElementFromArray.findNextGreaterElement(input3));

        // Test case: Example input [1, 2, 3, 4, 5]
        int[] input4 = {1, 2, 3, 4, 5};
        int[] expectedOutput4 = {2, 3, 4, 5, -1};
        assertArrayEquals(expectedOutput4, NextGreaterElementFromArray.findNextGreaterElement(input4));
    }
}
