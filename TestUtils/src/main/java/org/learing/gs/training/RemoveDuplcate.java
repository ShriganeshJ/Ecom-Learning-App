package org.learing.gs.training;

import java.util.Arrays;

public class RemoveDuplcate {
    public static void main(String[] args) {
        // Original array with duplicates
        Integer[] arrayWithDuplicates = {1, 2, 3, 4, 1, 2, 5};

        // Use Java streams to remove duplicates
        Integer[] arrayWithoutDuplicates = Arrays.stream(arrayWithDuplicates)
                .distinct()
                .toArray(Integer[]::new);

        // Print the array without duplicates
        System.out.println(Arrays.toString(arrayWithoutDuplicates));
    }
}
