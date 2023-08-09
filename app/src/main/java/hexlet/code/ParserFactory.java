package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

import static hexlet.code.Differ.getContent;
import static hexlet.code.Differ.getExtension;

public class ParserFactory {
    public static final String JSON = "json";
    public static final String YAML = "yaml";
    public static final String YML = "yml";

    public static Parser getParser(String extension) {
        switch (extension) {
            case JSON -> {
                return new JsonParser();
            }
            case YAML, YML -> {
                return new YmlParser();
            }
            default -> throw new IllegalArgumentException("Unknown extension. Try again.");
        }
    }
}

