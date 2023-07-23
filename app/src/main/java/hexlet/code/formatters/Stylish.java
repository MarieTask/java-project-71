package hexlet.code.formatters;

import java.util.*;

public class Stylish {
    public static String getStylish(List<Map<String, Object>> data) {
        StringBuilder sb = new StringBuilder("{\n");
        for (Map<String, Object> map: data) {
            // No changes
            if (map.get("status").equals("no changes")) {
                sb.append(String.format("    %s: %s\n", map.get("key"), map.get("Old value")));
                // Key value was update
            } else if (map.get("status").equals("updated")) {
                sb.append(String.format("  - %s: %s\n  + %s: %s\n", map.get("key"), map.get("Old value"),
                        map.get("key"), map.get("New value")));
                // Key was added
            } else if (map.get("status").equals("added")) {
                sb.append(String.format("  + %s: %s\n", map.get("key"), map.get("New value")));
                // Key was deleted
            } else {
                sb.append(String.format("  - %s: %s\n", map.get("key"), map.get("Old value")));
            }
        }
        return sb + "}";
    }
}
