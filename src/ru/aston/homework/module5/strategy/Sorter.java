package ru.aston.homework.module5.strategy;

public class Sorter<T extends Comparable<T>> {
    private SortStrategy<T> strategy;

    public Sorter(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public T[] sort(T[] data) {
        return strategy.sort(data);
    }
}