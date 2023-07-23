package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String getPlain(List<Map<String, Object>> data) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map: data) {
            if (map.get("status").equals("updated")) {
                sb.append(String.format("Property '%s' was updated. From %s to %s\n", map.get("key"), correctView(map.get("Old value")),
                        correctView(map.get("New value"))));
            } else if (map.get("status").equals("deleted")) {
                sb.append(String.format("Property '%s' was removed\n", map.get("key")));
            } else if (map.get("status").equals("added")) {
                sb.append(String.format("Property '%s' was added with value: %s\n", map.get("key"), correctView(map.get("New value"))));
            }
        }
        return sb.toString().trim();
    }

    public static Object correctView(Object obj) {
        if (obj instanceof String) {
            return "'" + obj + "'";
        } else if (obj instanceof Map) {
            return "[complex value]";
        } else if (obj instanceof List) {
            return "[complex value]";
        }
        return obj;
    }
}