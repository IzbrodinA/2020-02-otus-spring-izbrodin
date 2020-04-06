package ru.otus.hm3.izbrodin.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;
import ru.otus.hm3.izbrodin.cofigs.YamlProps;
import ru.otus.hm3.izbrodin.domain.Question;
import ru.otus.hm3.izbrodin.domain.exception.CsvException;
import ru.otus.hm3.izbrodin.service.LocaleService;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    private final LocaleService localeService;
    private final int maxQuestions;

    public QuestionDaoImpl(LocaleService localeService, YamlProps yamlProps) {
        this.localeService = localeService;
        this.maxQuestions = yamlProps.getNumberQuestion();
    }

    @Override
    public List<Question> getAllQuestion() {
        List<Question> questions = new ArrayList<>();
        try (InputStream inputStream = QuestionDaoImpl.class.getClassLoader().getResourceAsStream(localeService.getMessage("filePath"))) {
            Reader reader = new InputStreamReader(inputStream);
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator('\t')
                    .withIgnoreQuotations(true)
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();

            String[] line = csvReader.readNext();
            for (int i = 0; i < maxQuestions || line != null; i++, line = csvReader.readNext()) {
                questions.add(new Question(line[1], List.of(Arrays.copyOfRange(line, 2, 6)), line[6]));
            }
        } catch (CsvValidationException | IOException e) {
            throw new CsvException("exception.read.file");
        }

        if (questions.size() != maxQuestions) {
            throw new CsvException("exception.not.enough.question", String.valueOf(questions.size()), String.valueOf(maxQuestions));
        }
        return questions;

    }

}
