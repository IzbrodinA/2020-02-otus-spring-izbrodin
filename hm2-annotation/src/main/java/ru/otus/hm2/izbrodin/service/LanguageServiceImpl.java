package ru.otus.hm2.izbrodin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    private final IOService ioService;
    private final LocaleService localeService;
    private final PrinterService printerService;
    private final List<String> supportLanguage;

    public LanguageServiceImpl(IOService ioService,
                               LocaleService localeService,
                               PrinterService printerService,
                               @Value("#{'${support.language}'.split(',')}") List<String> supportLanguage) {
        this.ioService = ioService;
        this.localeService = localeService;
        this.printerService = printerService;
        this.supportLanguage = supportLanguage;
    }

    @Override
    public void setLanguage() {
        localeService.setLocale(readLanguage());
    }

    private String readLanguage() {
        String language = null;
        while (!supportLanguage.contains(language)) {
            printerService.printMessage("choose.language", String.join(", ", supportLanguage));
            language = ioService.readLine();
        }
        return language;
    }


}
