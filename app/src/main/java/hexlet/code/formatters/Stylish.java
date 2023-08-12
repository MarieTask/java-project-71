package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String getStylish(List<Map<String, Object>> data) {
        StringBuilder sb = new StringBuilder("{\n");
        String unchangedDate = "    %s: %s\n";
        String changedDate = "  - %s: %s\n  + %s: %s\n";
        String deletedDate = "  - %s: %s\n";
        String addedDate = "  + %s: %s\n";
        for (Map<String, Object> map: data) {
            var key = map.get("status").toString();
            switch (key) {
                case "unchanged" -> sb.append(String.format(unchangedDate, map.get("key"), map.get("old_value")));
                case "changed" -> sb.append(String.format(changedDate, map.get("key"),
                        map.get("old_value"), map.get("key"), map.get("new_value")));
                case "deleted" -> sb.append(String.format(deletedDate, map.get("key"), map.get("old_value")));
                case "added" -> sb.append(String.format(addedDate, map.get("key"), map.get("new_value")));
                default ->
                        throw new RuntimeException(key);
                }
            }
        return sb.append("}").toString();
    }
}
