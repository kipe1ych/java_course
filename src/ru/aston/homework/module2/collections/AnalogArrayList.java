package ru.aston.homework.module2.collections;

public class AnalogArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public AnalogArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;

        return true;
    }

    public E get(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();

        return (E) elements[index];
    }

    public boolean remove(Object o) {
        for(int i = 0; i < size; i++) {
            if(o.equals(elements[i])) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;

                return true;
            }
        }

        return false;
    }

    public void addAll(AnalogArrayList<E> other) {
        for(int i = 0; i < other.size; i++) {
            this.add(other.get(i));
        }
    }

    public boolean contains(Object o) {
        for(int i = 0; i < size; i++) {
            if(o.equals(elements[i])) return true;
        }

        return false;
    }

    private void ensureCapacity() {
        if(size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    public int size() {
        return size;
    }
}
