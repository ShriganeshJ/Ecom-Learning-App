package org.learing.gs.training;

import java.util.Arrays;

/**
 * An anagram of a string is another string that contain the same char
 * only order of char is diff
 */
public class StringAnagram {


    public static void main(String[] args) {
        String s1 = "LISTEN";
        String s2 = "SILENT";

        System.out.println("String is anagram+"+checkAnagram(s1,s2));


    }

    static boolean checkAnagram(String s1, String s2) {
        boolean flag=false;
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
         if (char1.length!=char2.length)
         {
             return flag=false;
         }

        Arrays.sort(char1);
        Arrays.sort(char2);
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] == char2[i]) {
                flag= true;
            } else {
              flag= false;
            }
        }
        return  flag;
    }



}
