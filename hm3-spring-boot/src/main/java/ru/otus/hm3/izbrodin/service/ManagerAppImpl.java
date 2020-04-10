package ru.otus.hm3.izbrodin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ManagerAppImpl implements ManagerApp {
    private final LanguageService languageService;
    private final QuizService quizService;

    @Override
    public void startApp() {
        languageService.setLanguage();
        quizService.startQuiz();
    }
}
