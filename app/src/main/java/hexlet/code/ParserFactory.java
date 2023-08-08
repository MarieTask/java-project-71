package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

import static hexlet.code.Differ.getContent;
import static hexlet.code.Differ.getExtension;

public class ParserFactory {
    public static Parser getParser(String extension) {
        switch (extension) {
            case "json" -> {
                return new JsonParser();
            }
            case "yaml", "yml" -> {
                return new YmlParser();
            }
            default -> throw new IllegalArgumentException("Unknown extension. Try again.");
        }
    }
}

