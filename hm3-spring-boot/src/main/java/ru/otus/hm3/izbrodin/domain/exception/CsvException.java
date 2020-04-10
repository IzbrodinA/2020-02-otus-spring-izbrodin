package ru.otus.hm3.izbrodin.domain.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class CsvException extends RuntimeException {
    private final String message;
    private String[] args;

    public CsvException(String message, String arg1) {
        this.message = message;
        args = new String[]{arg1};
    }

    public CsvException(String message, String arg1, String arg2) {
        this.message = message;
        args = new String[]{arg1, arg2};
    }

}
