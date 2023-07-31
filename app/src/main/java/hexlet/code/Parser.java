package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

import static hexlet.code.Differ.getExtension;

public class Parser {
    public static Map<String, Object> parse(String content, String extension) throws IOException {
        ObjectMapper om = determineExtension(extension);
        return om.readValue(content, new TypeReference<>() { });
    }
    public static ObjectMapper determineExtension(String path) throws IOException {
        if (getExtension(path).equalsIgnoreCase("json")) {
            return new ObjectMapper();
        } else if (getExtension(path).equalsIgnoreCase("yaml")) {
            return new ObjectMapper(new YAMLFactory());
        } else if (getExtension(path).equalsIgnoreCase("yml")) {
            return new ObjectMapper(new YAMLFactory());
        } else {
            throw new IOException("Unknown data format. Try again.");
        }
    }
}
