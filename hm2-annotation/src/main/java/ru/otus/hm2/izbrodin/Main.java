package ru.otus.hm2.izbrodin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.hm2.izbrodin.configuration.AppConfiguration;
import ru.otus.hm2.izbrodin.service.ManagerApp;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        ManagerApp managerApp = context.getBean(ManagerApp.class);
        managerApp.startApp();
    }
}
