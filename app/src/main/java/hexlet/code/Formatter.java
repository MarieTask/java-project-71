package hexlet.code;

import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String dataToRightFormat(List<Map<String, Object>> data, String extension) {
        return switch (extension) {
            case "stylish" -> Stylish.getStylish(data);
            case "json" -> Json.getJson(data);
            case "plain" -> Plain.getPlain(data);
            default -> throw new IllegalArgumentException("Unknown data extension:" + extension);
        };
    }
}
