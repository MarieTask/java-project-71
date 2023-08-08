package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser implements Parser {

    @Override
    public Parser parse(String content) {
        return (Parser) new ObjectMapper();
    }
}
