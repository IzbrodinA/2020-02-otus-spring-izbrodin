package ru.otus.hm2.izbrodin.service;

public interface LocaleService {

    String getMessage(String message);

    String getMessage(String message, String[] args);

    void setLocale(String language);
}
