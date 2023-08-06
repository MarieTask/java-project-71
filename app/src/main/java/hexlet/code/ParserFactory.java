package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

import static hexlet.code.Differ.getExtension;

public class ParserFactory extends Parser {
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
