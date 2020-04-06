package ru.otus.hm3.izbrodin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PrinterServiceImpl implements PrinterService {

    private final IOService ioService;
    private final LocaleService localeService;


    @Override
    public void printMessage(String message) {
        printMessage(message, (String) null);
    }

    @Override
    public void printMessage(String message, String... args) {
        ioService.printLine(localeService.getMessage(message, args));
    }


}
