package ru.otus.hm2.izbrodin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {

    private final MessageSource messageSource;
    private Locale locale;

    public LocaleServiceImpl(MessageSource messageSource,
                             @Value("#{ systemProperties['user.language'] }") String defaultLanguage) {
        this.messageSource = messageSource;
        this.locale = new Locale(defaultLanguage);
    }


    @Override
    public String getMessage(String message) {
        return getMessage(message, null);
    }

    @Override
    public String getMessage(String message, String[] args) {
        return messageSource.getMessage(message, args, locale);
    }

    @Override
    public void setLocale(String language) {
        this.locale = new Locale(language);
    }

}
