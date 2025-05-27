package ru.aston.homework.module2.collections;

public class AnalogLinkedList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    public void add(E value) {
        if(head == null) {
            head = new Node<>(value);
        } else {
            Node<E> current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value);
        }
        size++;
    }

    public boolean remove(Object value) {
        Node<E> current = head;
        Node<E> previous = null;
        while(current != null) {
            if(value == null && current.value == null || (current.value != null && current.value.equals(value))) {
                if(previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    public boolean contains(Object value) {
        Node<E> current = head;
        while(current != null) {
            if(value == null && current.value == null) return true;
            if(current.value != null && current.value.equals(value)) return true;
            current = current.next;
        }

        return false;
    }

    public E get(int index) {
        if(index<0 || index>=size) throw new IndexOutOfBoundsException();
        Node<E> current = head;
        for(int i=0; i<index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public int size() {
        return size;
    }
}