package ru.aston.homework.module2.collections;

public class AnalogHashSet<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private AnalogLinkedList<E>[] buckets;
    private int size;

    public AnalogHashSet() {
        this(DEFAULT_CAPACITY);
    }

    public AnalogHashSet(int capacity) {
        buckets = (AnalogLinkedList<E>[]) new AnalogLinkedList[capacity];
        for(int i = 0; i < capacity; i++) {
            buckets[i] = new AnalogLinkedList<>();
        }
    }

    public boolean add(E element) {
        if(contains(element)) return false;
        int bucketIndex = getBucketIndex(element);
        buckets[bucketIndex].add(element);
        size++;
        resize();

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

    private void resize() {
        if((double) size / buckets.length > 0.75) {
            AnalogLinkedList<E>[] oldBuckets = buckets;
            AnalogLinkedList<E>[] newBuckets = (AnalogLinkedList<E>[]) new AnalogLinkedList[oldBuckets.length * 2];
            buckets = newBuckets;
            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new AnalogLinkedList<>();
            }
            size = 0;

            for(AnalogLinkedList<E> bucket : oldBuckets) {
                for(int i=0; i<bucket.size(); i++) {
                    add(bucket.get(i));
                }
            }
        }
    }

    public int size() {
        return size;
    }
}
