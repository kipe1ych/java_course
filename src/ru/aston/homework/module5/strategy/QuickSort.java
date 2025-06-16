package ru.aston.homework.module5.strategy;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> implements SortStrategy<T> {
    @Override
    public T[] sort(T[] data) {
        T[] copy = Arrays.copyOf(data, data.length);
        quickSort(copy, 0, copy.length - 1);

        return copy;
    }

    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);

        return i + 1;
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
