package ru.aston.homework.module5.decorator;

import java.util.List;

class NewsServiceImpl implements NewsService {
    /**
     * Получает список самых свежих новостей
     *
     * @return список новостей
     */
    @Override
    public List<NewsItem> getLatestNews() {
        return List.of(
                new NewsItem(1, "Новость 1"),
                new NewsItem(2, "Новость 2")
        );
    }
}
