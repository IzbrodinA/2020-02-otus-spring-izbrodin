package ru.otus.hm3.izbrodin.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.hm3.izbrodin.dao.QuestionDao;
import ru.otus.hm3.izbrodin.domain.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


@SpringBootTest
class QuestionServiceImplTest {

    @Autowired
    private QuestionServiceImpl questionService;

    @MockBean
    private QuestionDao questionDao;

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