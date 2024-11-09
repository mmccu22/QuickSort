package org.example;

import org.example.QuickSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    // Positive Case: Typical input
    @Test
    void testPositiveCase() {
        int[] array = {3, 6, 2, 7, 5, 8, 4, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        QuickSort.quickSort(array);
        assertArrayEquals(expected, array);
    }

    // Negative Case: Null input
    @Test
    void testNegativeCaseNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            QuickSort.quickSort(null);
        });
        assertEquals("Array cannot be null", exception.getMessage());
    }

    // Performance Case: Large array
    @Test
    void testPerformanceCaseLargeArray() {
        int[] largeArray = new int[10000]; // Reduce array size for testing
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = largeArray.length - i; // Reverse order
        }
        QuickSort.quickSort(largeArray); // Ensure your QuickSort has an optimal pivot selection

        for (int i = 0; i < largeArray.length - 1; i++) {
            assertTrue(largeArray[i] <= largeArray[i + 1]);
        }
    }


    // Boundary Case: Empty array and single-element array
    @Test
    void testBoundaryCases() {
        int[] emptyArray = {};
        QuickSort.quickSort(emptyArray);
        assertArrayEquals(new int[]{}, emptyArray);

        int[] singleElementArray = {42};
        QuickSort.quickSort(singleElementArray);
        assertArrayEquals(new int[]{42}, singleElementArray);

        int[] duplicatesArray = {5, 3, 5, 2, 5, 1};
        int[] expected = {1, 2, 3, 5, 5, 5};
        QuickSort.quickSort(duplicatesArray);
        assertArrayEquals(expected, duplicatesArray);
    }

    // Idempotency Case: Sorting already sorted array
    @Test
    void testIdempotencyCase() {
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort.quickSort(sortedArray);
        assertArrayEquals(expected, sortedArray);

        // Run the sorting again and ensure result is still the same
        QuickSort.quickSort(sortedArray);
        assertArrayEquals(expected, sortedArray);
    }
}
