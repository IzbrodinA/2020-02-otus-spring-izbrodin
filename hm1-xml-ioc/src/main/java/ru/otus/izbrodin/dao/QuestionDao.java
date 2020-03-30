package ru.otus.izbrodin.dao;

import ru.otus.izbrodin.domain.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> getAllQuestion();
}
