package ru.otus.hm3.izbrodin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.hm3.izbrodin.service.ManagerApp;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        ManagerApp managerApp = context.getBean(ManagerApp.class);
        managerApp.startApp();
    }

}
