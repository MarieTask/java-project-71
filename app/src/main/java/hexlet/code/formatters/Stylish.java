package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String getStylish(List<Map<String, Object>> data) {
        StringBuilder sb = new StringBuilder("{\n");
        for (Map<String, Object> map: data) {
            if (map.get("status").equals("no changes")) {
                sb.append(String.format("    %s: %s\n", map.get("key"), map.get("Old value")));
            } else if (map.get("status").equals("updated")) {
                sb.append(String.format("  - %s: %s\n  + %s: %s\n", map.get("key"), map.get("Old value"),
                        map.get("key"), map.get("New value")));
            } else if (map.get("status").equals("deleted")) {
                sb.append(String.format("  - %s: %s\n", map.get("key"), map.get("Old value")));
            } else if (map.get("status").equals("added")) {
                sb.append(String.format("  + %s: %s\n", map.get("key"), map.get("New value")));
            }
        }
        return sb + "}";
    }
}
