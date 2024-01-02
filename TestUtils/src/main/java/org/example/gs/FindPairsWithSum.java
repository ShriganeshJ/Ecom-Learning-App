package org.example.gs;

import java.util.HashMap;
import java.util.Map;

public class FindPairsWithSum {

    public static void findThePairs(int[] array, int targetSum) {

        Map<Integer, Integer> seenNumbers = new HashMap<>();

        System.out.println("Pairs with sum " + targetSum + ":");
        for (int num : array) {
            int complement = targetSum - num;

            if (seenNumbers.containsKey(complement)) {
                System.out.println("(" + complement + ", " + num + ")");
            }

            seenNumbers.put(num, num);
        }
    }

    public static void main(String[] args) {


        findThePairs(new int[] {4, 6, 5, -10, 8, 5, 20}, 10);
    }
}