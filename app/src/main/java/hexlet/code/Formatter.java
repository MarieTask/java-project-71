package hexlet.code;

import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String dataToRightFormat(List<Map<String,Object>> data, String format) {
        return switch (format) {
            case "stylish" -> Stylish.getStylish(data);
            case "json" -> Json.getJson(data);
            default -> throw new IllegalArgumentException("Unknown data format" + format);
        };
    }
}
