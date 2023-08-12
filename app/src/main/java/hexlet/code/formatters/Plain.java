package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String getPlain(List<Map<String, Object>> data) {
        StringBuilder sb = new StringBuilder();
        String changedDate = "Property '%s' was updated. From %s to %s\n";
        String deletedDate = "Property '%s' was removed\n";
        String addedDate = "Property '%s' was added with value: %s\n";
        for (Map<String, Object> map: data) {
            var key = map.get("status").toString();
            switch (key) {
                case "changed" -> sb.append(String.format(changedDate, map.get("key"),
                        normalize(map.get("old_value")), normalize(map.get("new_value"))));
                case "deleted" -> sb.append(String.format(deletedDate, map.get("key")));
                case "added" -> sb.append(String.format(addedDate, map.get("key"),
                        normalize(map.get("new_value"))));
                default ->
                        throw new RuntimeException(key);
            }
        }
        return sb.toString().trim();
    }

    public static Object normalize(Object obj) {
        if (obj instanceof String) {
            return "'" + obj + "'";
        } else if (obj instanceof Map || obj instanceof List) {
            return "[complex value]";
        }
        return String.valueOf(obj);
    }
}
