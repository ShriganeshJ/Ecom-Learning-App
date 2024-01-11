package org.core.java.collection;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashTable is using enumeration so there is no Fail-fast/Fail-Safe
 * HashMap is fail-fast
 * ConCurrentHashMap s fail-Safe
 *
 * @ConcurrentModificationException
 */
public class HTableHMapHConMapFailFastTest {

    public static void main(String[] args) {
        //hashTable
        hashTableTest();
        //concurrent Hash Map
        concurrentHashMapTest();
        //HashMap test
        hashMap();

    }

    public static void concurrentHashMapTest() {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        hashMap.put("test", "test");
        hashMap.put("key", "value");

        hashMap.forEach((s, s2) -> {

            hashMap.put("a", "c");

            System.out.println("conCurrrentHashMap"+s2);


        });
    }

    public static void hashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("test", "test");
        hashMap.put("key", "value");

        hashMap.forEach((s, s2) -> {

            hashMap.put("a", "c");


        });
    }

    public static void hashTableTest() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("abc", "xxx");
        hashtable.put("wxy", "abcd");
        hashtable.put("wxyh", "abcjd");
        hashtable.put("wxyr", "abckd");
        Enumeration<String> it = hashtable.elements();

        while (it.hasMoreElements()) {
            hashtable.put("RRabc", "with enumeration it fail safe");
            System.out.println(it.nextElement());
            System.out.println();
        }
        System.out.println("---------for each-------");
        hashtable.forEach((s, s2) ->
                System.out.println("key::" + s + "  " + "value::" + s2)
        );
    }

}