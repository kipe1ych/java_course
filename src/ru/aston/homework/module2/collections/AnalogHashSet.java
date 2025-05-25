package ru.aston.homework.module2.collections;

public class AnalogHashSet<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private AnalogArrayList<E>[] buckets;
    private int size;

    public AnalogHashSet() {
        this(DEFAULT_CAPACITY);
    }

    public AnalogHashSet(int capacity) {
        buckets = new AnalogArrayList[capacity];
        for(int i = 0; i < capacity; i++) {
            buckets[i] = new AnalogArrayList<>();
        }
    }

    public boolean add(E element) {
        if(contains(element)) return false;
        int bucketIndex = getBucketIndex(element);
        buckets[bucketIndex].add(element);
        size++;

        return true;
    }

    public boolean remove(E element) {
        int bucketIndex = getBucketIndex(element);
        boolean removed = buckets[bucketIndex].remove(element);
        if(removed) size--;

        return removed;
    }

    private int getBucketIndex(E element) {
        return Math.abs(element.hashCode()) % buckets.length;
    }

    public boolean contains(E element) {
        int bucketIndex = getBucketIndex(element);

        return buckets[bucketIndex].contains(element);
    }

    public int size() {
        return size;
    }
}
