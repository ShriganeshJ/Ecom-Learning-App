package org.learing.gs.training;

    import java.util.LinkedList;

     class CustomHashMap<K, V> {
        private static final int DEFAULT_CAPACITY = 16;
        private static final double LOAD_FACTOR = 0.75;

        private LinkedList<Entry<K, V>>[] buckets;
        private int size;

        public CustomHashMap() {
            this(DEFAULT_CAPACITY);
        }

        public CustomHashMap(int initialCapacity) {
            this.buckets = new LinkedList[initialCapacity];
            this.size = 0;
        }

        public void put(K key, V value) {
            int index = getIndex(key);
            if (buckets[index] == null) {
                buckets[index] = new LinkedList<>();
            }

            // Check if the key already exists, update the value
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }

            // Add a new entry
            buckets[index].add(new Entry<>(key, value));
            size++;

            // Check if the array needs to be resized
            if ((double) size / buckets.length > LOAD_FACTOR) {
                resize();
            }
        }

        public V get(K key) {
            int index = getIndex(key);
            if (buckets[index] != null) {
                for (Entry<K, V> entry : buckets[index]) {
                    if (entry.key.equals(key)) {
                        return entry.value;
                    }
                }
            }
            return null; // Key not found
        }

        public int size() {
            return size;
        }

        private int getIndex(K key) {
            return key.hashCode() % buckets.length;
        }

        private void resize() {
            int newCapacity = buckets.length * 2;
            LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[newCapacity];

            for (LinkedList<Entry<K, V>> bucket : buckets) {
                if (bucket != null) {
                    for (Entry<K, V> entry : bucket) {
                        int index = entry.key.hashCode() % newCapacity;
                        if (newBuckets[index] == null) {
                            newBuckets[index] = new LinkedList<>();
                        }
                        newBuckets[index].add(entry);
                    }
                }
            }

            buckets = newBuckets;
        }

        private static class Entry<K, V> {
            K key;
            V value;

            public Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }



public class CustomHashMapExample {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Size: " + map.size());
        System.out.println("Value for key 'two': " + map.get("two"));
    }
}


