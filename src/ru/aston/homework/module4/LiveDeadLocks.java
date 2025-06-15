package ru.aston.homework.module4;

import java.util.concurrent.atomic.AtomicBoolean;

public class LiveDeadLocks {
    /**
     * deadlock с двумя потоками
     */
    public void deadlock() {
        Object closure1 = new Object();
        Object closure2 = new Object();

        new Thread(() -> {
            synchronized (closure1) {
                synchronized (closure2) {

                }
            }
        }).start();

        new Thread(() -> {
            synchronized (closure2) {
                synchronized (closure1) {

                }
            }
        }).start();
    }

    /**
     * livelock с двумя потоками
     */
    public static void livelock() {
        AtomicBoolean currentTurn = new AtomicBoolean(true);

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (currentTurn.get()) {
                    currentTurn.set(false);
                }
            }
        }).start();

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (!currentTurn.get()) {
                    currentTurn.set(true);
                }
            }
        }).start();
    }
}
