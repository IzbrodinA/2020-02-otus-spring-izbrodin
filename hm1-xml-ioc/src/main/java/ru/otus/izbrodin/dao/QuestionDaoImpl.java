package ru.otus.izbrodin.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import ru.otus.izbrodin.domain.Question;
import ru.otus.izbrodin.domain.exception.CsvException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {
    private static final int MAX_QUESTIONS = 5;
    private final String fileName;

    @Override
    public List<Question> getAllQuestion() {
        List<Question> questions = new ArrayList<>();
        try (InputStream inputStream = QuestionDaoImpl.class.getClassLoader().getResourceAsStream(fileName);) {
            Reader reader = new InputStreamReader(inputStream, Charset.forName("windows-1251"));
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator('\t')
                    .withIgnoreQuotations(true)
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();

            String[] line = csvReader.readNext();
            for (int i = 0; i < MAX_QUESTIONS || line != null; i++, line = csvReader.readNext()) {
                questions.add(new Question(line[1], List.of(Arrays.copyOfRange(line, 2, 6)), line[6]));
            }
        } catch (CsvValidationException | IOException e) {
            throw new CsvException("Проблема при чтение сборника вопросов.");
        }

        if (questions.size() != MAX_QUESTIONS) {
            throw new CsvException("Вопросов было прочитано " + questions.size());
        }
        return questions;

    }

}
