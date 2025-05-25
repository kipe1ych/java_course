package ru.aston.homework.module2;

import java.util.Collections;
import java.util.List;

public class Student {
    private String name;
    private List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    @Override
    public String toString() {
        return "Студент: " + name + ". Всего книг: " + books.size() + ".";
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
