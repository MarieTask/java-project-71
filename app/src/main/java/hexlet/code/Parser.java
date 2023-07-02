package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String fileFormat) throws IOException {
        ObjectMapper om = determineFormat(fileFormat);
        return om.readValue(content, new TypeReference<>() { });
    }
    public static ObjectMapper determineFormat(String format) throws IOException {
        if (format.equalsIgnoreCase("json")) {
            return new ObjectMapper();
        } else if (format.equalsIgnoreCase("yaml")) {
            return new ObjectMapper(new YAMLFactory());
        } else if (format.equalsIgnoreCase("yml")) {
            return new ObjectMapper(new YAMLFactory());
        } else {
            throw new IOException("Unknown data format. Try again.");
        }
    }
}
