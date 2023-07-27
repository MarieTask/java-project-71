package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String extension) throws IOException {
        ObjectMapper om = determineExtension(extension);
        return om.readValue(content, new TypeReference<>() { });
    }
    public static ObjectMapper determineExtension(String extension) throws IOException {
        if (extension.equalsIgnoreCase("json")) {
            return new ObjectMapper();
        } else if (extension.equalsIgnoreCase("yaml")) {
            return new ObjectMapper(new YAMLFactory());
        } else if (extension.equalsIgnoreCase("yml")) {
            return new ObjectMapper(new YAMLFactory());
        } else {
            throw new IOException("Unknown data format. Try again.");
        }
    }
}
