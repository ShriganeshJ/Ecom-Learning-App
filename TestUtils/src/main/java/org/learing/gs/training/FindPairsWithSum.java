package org.learing.gs.training;

import java.util.HashMap;
import java.util.Map;

public class FindPairsWithSum {

    public static void findThePairs(int[] array, int targetSum) {

        Map<Integer, Integer> seenNumbers = new HashMap<>();

        System.out.println("Pairs with sum " + targetSum + ":");
        for (int num : array) {
            //target 10
            //10-4 =complement =6
            //10-6=complement =4
            int complement = targetSum - num;

            if (seenNumbers.containsKey(complement)) {
                System.out.println("(" + complement + ", " + num + ")");
            }
             //4,4
            //6,6
            seenNumbers.put(num, num);
        }
    }

    public static void main(String[] args) {


        findThePairs(new int[] {4, 6, 5, -10, 8, 5, 20}, 10);
    }
}