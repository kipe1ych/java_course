package ru.aston.homework.module5.strategy;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> implements SortStrategy<T> {
    @Override
    public T[] sort(T[] data) {
        T[] copy = Arrays.copyOf(data, data.length);
        int n = copy.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (copy[j].compareTo(copy[j+1]) > 0) {
                    T temp = copy[j];
                    copy[j] = copy[j+1];
                    copy[j+1] = temp;
                }
            }
        }

        return copy;
    }
}
