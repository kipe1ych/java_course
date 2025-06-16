package ru.aston.homework.module5.decorator;

import java.util.List;
import java.util.logging.Logger;

class LoggedNewsService extends NewsServiceDecorator {
    private final Logger logger;

    /**
     * Создаёт декоратор с логгированием
     *
     * @param newsService оригинальный сервис
     * @param logger логгер для вывода информации
     */
    public LoggedNewsService(NewsService newsService, Logger logger) {
        super(newsService);
        this.logger = logger;
    }

    /**
     * Получает список новостей и логгирует время выполнения
     *
     * @return список новостей
     */
    @Override
    public List<NewsItem> getLatestNews() {
        long start = System.currentTimeMillis();
        List<NewsItem> news = wrapped.getLatestNews();
        long duration = System.currentTimeMillis() - start;

        logger.info("Загружено " + news.size() + " новостей за " + duration + " мс");

        return news;
    }
}
