package test.map;

import java.util.Arrays;

public class HashMap<K, V> {

    private static class Entry<K, V> {

        private final K key;
        private V value;
        private Entry<K, V> next;

        private Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private Entry<K, V>[] buckets;

    public HashMap() {
        this(16);
    }

    public HashMap(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.buckets = new Entry[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K key) {
        if (key == null)
            return false;
        int index = key.hashCode() % buckets.length;
        Entry<K, V> head = buckets[index];
        while (head != null) {
            if (head.key.equals(key))
                return true;
            head = head.next;
        }
        return false;
    }

    public V put(K key, V value) {
        if (key == null)
            return null;
        int index = key.hashCode() % buckets.length;
        Entry<K, V> head = buckets[index];
        while (head != null) {
            if (head.key.equals(key)) {
                V oldValue = head.value;
                head.value = value;
                return oldValue;
            }
            head = head.next;
        }
        Entry<K, V> entry = new Entry<>(key, value, buckets[index]);
        buckets[index] = entry;
        size++;
        return null;
    }

    public V get(K key) {
        if (key == null)
            return null;
        int index = key.hashCode() % buckets.length;
        Entry<K, V> head = buckets[index];
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        if (key == null)
            return null;
        int index = key.hashCode() % buckets.length;
        Entry<K, V> head = buckets[index];
        Entry<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null)
                    buckets[index] = head.next;
                else
                    prev.next = head.next;
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(buckets);
    }

    public static void main(String[] args) {
        HashMap<Long, String> hashMap = new HashMap();

        hashMap.put(3l, "");
        hashMap.put(3l, "a");
        java.util.HashMap<Long, String> longStringHashMap = new java.util.HashMap<>();
        longStringHashMap.put(3l, "");
        longStringHashMap.put(3l, "a");
        System.out.println(hashMap.get(3l));
        System.out.println(longStringHashMap.containsValue("a"));
    }
}