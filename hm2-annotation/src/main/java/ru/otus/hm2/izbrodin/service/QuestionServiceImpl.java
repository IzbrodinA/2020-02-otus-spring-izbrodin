package ru.otus.hm2.izbrodin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hm2.izbrodin.dao.QuestionDao;
import ru.otus.hm2.izbrodin.domain.Question;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;

    @Override
    public List<Question> getAllQuestion() {
        return dao.getAllQuestion();
    }
}
