package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String getStylish(List<Map<String, Object>> data) {
        StringBuilder sb = new StringBuilder("{\n");
        for (Map<String, Object> map: data) {
            var key = map.get("status").toString();
            switch (key) {
                case "no changes" -> sb.append(String.format("    %s: %s\n", map.get("key"), map.get("old_value")));
                case "updated" -> sb.append(String.format("  - %s: %s\n  + %s: %s\n", map.get("key"),
                        map.get("old_value"), map.get("key"), map.get("new_value")));
                case "deleted" -> sb.append(String.format("  - %s: %s\n", map.get("key"), map.get("old_value")));
                case "added" -> sb.append(String.format("  + %s: %s\n", map.get("key"), map.get("new_value")));
                default -> {
                }
            }
        }
        return sb.append("}").toString();
    }
}
