package org.learing.gs;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicatesInArray {

    public static List<Integer> findDuplicates(int[] array) {
        // Create a Map with the frequency of each element
        Map<Integer, Long> frequencyMap = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        // Filter the Map to get elements with frequency greater than 1 (duplicates)
        List<Integer> duplicates = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return duplicates;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 2, 5, 6, 1, 7, 8, 8};

        // Find duplicates in the array
        List<Integer> duplicateList = findDuplicates(array);

        // Print the duplicates
        System.out.println("Duplicates in the array: " + duplicateList);
    }
}