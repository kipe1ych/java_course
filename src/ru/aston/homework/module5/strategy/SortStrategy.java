package ru.aston.homework.module5.strategy;

public interface SortStrategy<T extends Comparable<T>> {
    /**
     * Сортирует массив элементов
     *
     * @param data исходный массив
     * @return отсортированный массив
     */
    T[] sort(T[] data);
}
