package com.sorting.test;

import org.junit.jupiter.api.Test;
import com.sorting.NearestNeighbour;
import static org.junit.jupiter.api.Assertions.*;

public class NearestNeighbourTest {

    @Test
    void testFindNearest() {
        // Test case 1
        int[] arr1 = {2, 7, 15, 25, 30};
        int target1 = 17;
        int expected1 = 15;
        assertEquals(expected1, NearestNeighbour.findNearest(arr1, target1));

        // Test case 2
        int[] arr2 = {5, 10, 20, 40};
        int target2 = 35;
        int expected2 = 40;
        assertEquals(expected2, NearestNeighbour.findNearest(arr2, target2));

        // Test case 3: Test when the array contains negative values
        int[] arr3 = {-10, -5, 0, 5, 10};
        int target3 = -7;
        int expected3 = -5;
        assertEquals(expected3, NearestNeighbour.findNearest(arr3, target3));
    }

    @Test
    void testExpectedException() {
        IllegalArgumentException thrownByNull = assertThrows(IllegalArgumentException.class, () -> {
            int[] arr = null;
            int target = 100;
            NearestNeighbour.findNearest(arr, target);
        });
        assertEquals("The input array is null or empty.", thrownByNull.getMessage());

        IllegalArgumentException thrownByEmpty = assertThrows(IllegalArgumentException.class, () -> {
            int[] arr = {};
            int target = 100;
            NearestNeighbour.findNearest(arr, target);
        });
        assertEquals("The input array is null or empty.", thrownByEmpty.getMessage());
    }
}
