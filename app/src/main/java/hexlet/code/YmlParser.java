package hexlet.code;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YmlParser implements Parser {
    @Override
    public Parser parse(String content) {
        return (Parser) new YAMLFactory();
    }
}
