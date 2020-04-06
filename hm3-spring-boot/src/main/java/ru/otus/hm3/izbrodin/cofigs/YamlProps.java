package ru.otus.hm3.izbrodin.cofigs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "application")
public class YamlProps {

    private int numberQuestion;
    private List<String> language = new ArrayList<>();

}