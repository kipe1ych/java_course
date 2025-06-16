package ru.aston.homework.module5.decorator;

public class NewsItem {
    private int id;
    private String title;

    /**
     * Создаёт объект новости.
     *
     * @param id идентификатор новости
     * @param title заголовок новости
     */
    public NewsItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
