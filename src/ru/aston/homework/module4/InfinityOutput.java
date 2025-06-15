package ru.aston.homework.module4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InfinityOutput {
    private final Object closure = new Object();
    private final AtomicInteger currentTurn = new AtomicInteger(0);
    private final List<Thread> threads = new ArrayList<>();
    private static volatile boolean running = true;
    private final int turnCount;

    /**
     * Создает экземпляр InfinityOutput с указанным количеством потоков
     *
     * @param turnCount количество потоков
     * @throws IllegalArgumentException если turnCount <= 0
     */
    public InfinityOutput(int turnCount) {
        if (turnCount <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным");
        }
        this.turnCount = turnCount;
    }

    /**
     * Запускает все потоки
     * Каждый поток выводит свой номер по очереди
     */
    public void start() {
        for (int i = 0; i < turnCount; i++) {
            final int threadNumber = i;
            Thread thread = new Thread(() -> {
                while (running && !Thread.currentThread().isInterrupted()) {
                    synchronized (closure) {
                        try {
                            while (running && currentTurn.get() != threadNumber) closure.wait();
                            if (!running) break;
                            System.out.println(threadNumber + 1);
                            currentTurn.set((threadNumber + 1) % turnCount);
                            closure.notifyAll();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
    }

    /**
     * Останавливает все потоки
     */
    public void stop() {
        running = false;
        synchronized (closure) {
            closure.notifyAll();
        }
        threads.forEach(Thread::interrupt);
    }
}
