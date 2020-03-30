package ru.otus.izbrodin.service;

import lombok.RequiredArgsConstructor;
import ru.otus.izbrodin.dao.QuestionDao;
import ru.otus.izbrodin.domain.Question;

import java.util.List;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;

    @Override
    public List<Question> getAllQuestion() {
        return dao.getAllQuestion();
    }
}
