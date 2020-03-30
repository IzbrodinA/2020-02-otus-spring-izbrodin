package ru.otus.izbrodin.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.izbrodin.dao.QuestionDao;
import ru.otus.izbrodin.domain.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

    @Mock
    private QuestionDao questionDao;

    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService = new QuestionServiceImpl(questionDao);
    }

    @Test
    void getAllQuestion() {

        Question test = new Question("Test question", List.of("Answer A, Answer B"), "999");
        given(questionDao.getAllQuestion())
                .willReturn(List.of(test));

        List<Question> result = questionService.getAllQuestion();

        assertEquals(1, result.size());
        assertEquals("999", result.get(0).getNumberRightAnswer());
        assertEquals("Test question", result.get(0).getQuestion());
    }


}