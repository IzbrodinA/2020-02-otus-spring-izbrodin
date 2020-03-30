package ru.otus.izbrodin.service;

import lombok.RequiredArgsConstructor;
import ru.otus.izbrodin.domain.Question;
import ru.otus.izbrodin.domain.exception.CsvException;

import java.util.List;

@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final IOService ioService;
    private final QuestionService questionService;

    @Override
    public void startQuiz() {
        try {
            List<Question> questions = questionService.getAllQuestion();
            ioService.printLine("Введите имя и фамилию");
            String name = ioService.readLine();
            int result = questions.stream().mapToInt(this::printQuestions).sum();
            ioService.printLine(name + " дал " + result + " правильных ответа");
        } catch (CsvException ex) {
            ioService.printLine(ex.getLocalizedMessage());
        }
    }

    private int printQuestions(Question question) {
        ioService.printLine(question.getQuestion());
        List<String> answers = question.getAnswers();
        ioService.printLine("Варианты ответов:");
        for (int i = 0; i < answers.size(); i++) {
            ioService.printLine(i + 1 + ". " + answers.get(i));
        }
        ioService.printLine("Введите номер ответа.");
        String numberRightAnswer = question.getNumberRightAnswer();
        if (ioService.readLine().equals(numberRightAnswer)) {
            ioService.printLine("Верно");
            return 1;
        } else {
            ioService.printLine("Правильный номер ответа " + numberRightAnswer);
            return 0;
        }
    }
}
