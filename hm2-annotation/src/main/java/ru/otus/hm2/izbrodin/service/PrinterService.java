package ru.otus.hm2.izbrodin.service;

public interface PrinterService {

    void printMessage(String message, String... args);

    void printMessage(String message);

}
