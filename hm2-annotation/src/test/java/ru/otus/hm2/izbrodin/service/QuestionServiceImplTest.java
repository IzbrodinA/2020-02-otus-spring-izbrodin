package ru.otus.hm2.izbrodin.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.otus.hm2.izbrodin.dao.QuestionDao;
import ru.otus.hm2.izbrodin.domain.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

class QuestionServiceImplTest {

    @InjectMocks
    private QuestionServiceImpl questionService;
    @Mock
    private QuestionDao questionDao;

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.initMocks(this);
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