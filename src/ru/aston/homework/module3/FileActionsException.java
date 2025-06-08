package ru.aston.homework.module3;

import java.io.Serial;

public class FileActionsException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public FileActionsException() {
        super();
    }

    public FileActionsException(String message) {
        super(message);
    }

    public FileActionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileActionsException(Throwable cause) {
        super(cause);
    }
}
