package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String getPlain(List<Map<String, Object>> data) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map: data) {
            var key = map.get("status").toString();
            switch (key) {
                case "updated" -> sb.append(String.format("Property '%s' was updated. From %s to %s\n",
                        map.get("key"), correctView(map.get("old_value")), correctView(map.get("new_value"))));
                case "deleted" -> sb.append(String.format("Property '%s' was removed\n", map.get("key")));
                case "added" -> sb.append(String.format("Property '%s' was added with value: %s\n",
                        map.get("key"), correctView(map.get("new_value"))));
                default -> {
                }
            }
        }
        return sb.toString().trim();
    }

    public static Object correctView(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof String) {
            return "'" + obj + "'";
        } else if (obj instanceof Map || obj instanceof List) {
            return "[complex value]";
        }
        return String.valueOf(obj);
    }
}
