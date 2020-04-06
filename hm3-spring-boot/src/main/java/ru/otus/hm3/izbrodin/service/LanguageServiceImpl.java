package ru.otus.hm3.izbrodin.service;

import org.springframework.stereotype.Service;
import ru.otus.hm3.izbrodin.cofigs.YamlProps;

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
                               YamlProps yamlProps) {
        this.ioService = ioService;
        this.localeService = localeService;
        this.printerService = printerService;
        this.supportLanguage = yamlProps.getLanguage();
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
