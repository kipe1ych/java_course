package ru.aston.homework.intensiveModule1;

import java.util.Objects;

public class AnalogHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<K, V>[] buckets;
    private int size;
    private int capacity;

    /**
     * Хранение пары ключ-значение
     */
    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public AnalogHashMap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public AnalogHashMap(int initialCapacity) {
        this.capacity = initialCapacity;
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    /**
     * Возвращает индекс бакета по хэшу ключа
     */
    private int hashIndex(Object key) {
        if (key == null) return 0;
        int hash = key.hashCode();

        return Math.abs(hash) % capacity;
    }

    /**
     * Добавляет пару ключ-значение в карту
     * Если ключ уже существует, заменяет значение
     *
     * @param key   ключ
     * @param value значение
     * @return старое значение или null
     */
    public V put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Ключ не может быть null");

        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }

        int index = hashIndex(key);
        Node<K, V> head = buckets[index];

        for (Node<K, V> current = head; current != null; current = current.next) {
            if (Objects.equals(current.key, key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        buckets[index] = newNode;
        size++;

        return null;
    }

    /**
     * Возвращает значение по ключу
     *
     * @param key ключ
     * @return значение или null, если ключ не найден
     */
    public V get(Object key) {
        if (key == null) return null;

        int index = hashIndex(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    /**
     * Удаляет элемент по ключу
     *
     * @param key ключ
     * @return удалённое значение или null
     */
    public V remove(Object key) {
        if (key == null) return null;

        int index = hashIndex(key);
        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (Objects.equals(head.key, key)) {
                V value = head.value;

                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }

                size--;

                return value;
            }

            prev = head;
            head = head.next;
        }

        return null;
    }

    /**
     * Увеличивает размер таблицы и перераспределяет элементы
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new Node[capacity];
        size = 0;

        for (Node<K, V> bucket : oldBuckets) {
            Node<K, V> current = bucket;
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }

    /**
     * Возвращает количество элементов
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуста ли карта
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (Node<K, V> bucket : buckets) {
            Node<K, V> current = bucket;
            while (current != null) {
                if (!first) sb.append(", ");
                sb.append(current.key).append("=").append(current.value);
                first = false;
                current = current.next;
            }
        }
        sb.append("}");

        return sb.toString();
    }
}
