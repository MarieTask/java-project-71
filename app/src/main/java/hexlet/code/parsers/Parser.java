package hexlet.code.parsers;

import java.util.Map;

public interface Parser {
    Map<String, Object> parse(String content);
}
