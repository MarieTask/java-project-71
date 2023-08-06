package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

import static hexlet.code.Differ.getExtension;
import static hexlet.code.ParserFactory.determineExtension;

public class Parser {
    public static Map<String, Object> parse(String content, String extension) throws IOException {
        ObjectMapper om = determineExtension(extension);
        return om.readValue(content, new TypeReference<>() { });
    }
}
