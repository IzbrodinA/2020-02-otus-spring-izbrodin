package ru.otus.hm2.izbrodin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hm2.izbrodin.domain.Question;
import ru.otus.hm2.izbrodin.domain.exception.CsvException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizServiceImpl implements QuizService {

    private final IOService ioService;
    private final QuestionService questionService;
    private final PrinterService printerService;


    @Override
    public void startQuiz() {
        try {
            List<Question> questions = questionService.getAllQuestion();
            printerService.printMessage("write.name");
            String name = ioService.readLine();
            int result = questions.stream().mapToInt(this::printQuestions).sum();
            printerService.printMessage("show.result", name, String.valueOf(result));
        } catch (CsvException ex) {
            printerService.printMessage(ex.getMessage(), ex.getArgs());
        }
    }

    private int printQuestions(Question question) {
        ioService.printLine(question.getQuestion());
        List<String> answers = question.getAnswers();
        printerService.printMessage("option.answer");
        for (int i = 0; i < answers.size(); i++) {
            ioService.printLine(i + 1 + ". " + answers.get(i));
        }
        printerService.printMessage("print.answer");
        String numberRightAnswer = question.getNumberRightAnswer();
        if (ioService.readLine().equals(numberRightAnswer)) {
            printerService.printMessage("right.answer");
            return 1;
        } else {
            printerService.printMessage("wrong.answer", String.valueOf(numberRightAnswer));
            return 0;
        }
    }

}
