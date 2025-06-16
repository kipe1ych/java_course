package ru.aston.homework.module5.decorator;

import java.util.List;

abstract class NewsServiceDecorator implements NewsService {
    protected final NewsService wrapped;

    /**
     * Оборачивает существующий сервис новостей
     *
     * @param newsService оригинальный сервис
     */
    public NewsServiceDecorator(NewsService newsService) {
        this.wrapped = newsService;
    }

    /**
     * Делегирует вызов оригинальному сервису
     *
     * @return список новостей
     */
    @Override
    public List<NewsItem> getLatestNews() {
        return wrapped.getLatestNews();
    }
}
