package dev.kartikbhalla;

import java.util.LinkedList;

public class HashTable {

    /* Usage Example
        HashTable table = new HashTable();
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        System.out.println(table.get(8));
        System.out.println(table.remove(8));
        System.out.println(table.get(8));
        System.out.println(table.remove(8));
     */

    private class Entry {
        public int key;
        public String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key)
                .addLast(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);
        if (entry == null) return null;

        return entry.value;
    }

    public String remove(int key) {
        var entry = getEntry(key);
        if (entry == null) throw new IllegalStateException();

        getBucket(key).remove(entry);
        return entry.value;
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        var bucket = getBucket(key);
        if (isBucketEmpty(bucket))
            entries[index] = new LinkedList<>();
        return bucket;
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);

        if (!isBucketEmpty(bucket))
            for (Entry entry : bucket)
                if (entry.key == key) return entry;

        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private boolean isBucketEmpty(LinkedList<Entry> bucket) {
        return bucket == null;
    }

    private int hash(int key) {
        return key % entries.length;
    }

}
