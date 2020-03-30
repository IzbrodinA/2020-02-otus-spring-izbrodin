package ru.otus.izbrodin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.izbrodin.service.QuizService;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuizService quizService = context.getBean(QuizService.class);
        quizService.startQuiz();
    }
}
