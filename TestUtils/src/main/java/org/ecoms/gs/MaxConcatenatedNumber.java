package org.ecoms.gs;

import java.util.Arrays;
import java.util.Comparator;

public class MaxConcatenatedNumber {

    public static String findMaxConcatenatedNumber(int[] arr) {
        // Convert array elements to strings for easy concatenation
        String[] arrStr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrStr[i] = String.valueOf(arr[i]);
        }

        // Use a custom comparator to sort in descending order based on concatenated values
        Arrays.sort(arrStr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Concatenate in different orders and compare
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Compare in descending order
            }
        });

        // Concatenate sorted strings to get the maximum possible number
        StringBuilder result = new StringBuilder();
        for (String s : arrStr) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 50, 8};

        String maxConcatenatedNumber = findMaxConcatenatedNumber(arr);
        System.out.println("Maximum concatenated number: " + maxConcatenatedNumber);
    }
}