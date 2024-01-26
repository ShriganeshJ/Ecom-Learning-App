package org.learing.gs;

import java.util.Arrays;

public class SecondHighestNumber {

    public static int findSecondHighest(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Array should have at least two elements");
        }

        // Use a stream to sort the array in descending order and skip the first element
        return Arrays.stream(array)
                .boxed() // Convert int to Integer for sorting
                .sorted((a, b) -> b.compareTo(a)) // Sort in descending order
                .skip(1) // Skip the first element (highest)
                .findFirst() // Get the second highest
                .orElseThrow(() -> new IllegalStateException("Array is empty"));
    }

    public static void main(String[] args) {
        int[] array = {5, 8, 1, 3, 9, 4};

        // Find the second highest number
        int secondHighest = findSecondHighest(array);

        System.out.println("Second Highest Number: " + secondHighest);
    }
}