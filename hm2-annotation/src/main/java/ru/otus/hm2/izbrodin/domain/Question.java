package ru.otus.hm2.izbrodin.domain;

import lombok.Data;

import java.util.List;

@Data
public class Question {

    private final String question;
    private final List<String> answers;
    private final String numberRightAnswer;


}
