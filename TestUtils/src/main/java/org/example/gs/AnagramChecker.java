package org.example.gs;

import java.util.Arrays;

public class AnagramChecker {

    public static boolean areAnagrams(String str1, String str2) {


        // Convert strings to streams of characters, sort, and collect to arrays
        Character[] charArray1 = str1.chars().sorted().mapToObj(c -> (char) c).toArray(Character[]::new);
        Character[] charArray2 = str2.chars().sorted().mapToObj(c -> (char) c).toArray(Character[]::new);

        // Compare sorted character arrays
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        // Check if the strings are anagrams
        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}