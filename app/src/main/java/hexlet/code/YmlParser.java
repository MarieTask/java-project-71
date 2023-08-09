package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class YmlParser implements Parser {
    public Map<String, Object> parse(String content) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(content, new TypeReference<>() { });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
