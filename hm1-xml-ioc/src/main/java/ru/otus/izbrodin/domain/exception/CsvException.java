package ru.otus.izbrodin.domain.exception;

public class CsvException extends RuntimeException {
    public CsvException() {
    }

    public CsvException(String message) {
        super(message);
    }
}
