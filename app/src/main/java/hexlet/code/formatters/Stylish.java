package hexlet.code.formatters;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;

public class Stylish {
    public static String getStylish() {
        Set<String> keyFile = new TreeSet<>(map1.keySet());
        keyFile.addAll(map2.keySet());

        String result = "{\n";
        for (String key: keyFile) {
            // No changes
            if (Objects.equals(map1.get(key), map2.get(key))) {
                result += String.format("    %s: %s\n", key, map1.get(key));
                // Key value was update
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                result += String.format("  - %s: %s\n  + %s: %s\n", key, map1.get(key), key, map2.get(key));
                // Key was added
            } else if (!map1.containsKey(key)) {
                result += String.format("  + %s: %s\n", key, map2.get(key));
                // Key was deleted
            } else {
                result += String.format("  - %s: %s\n", key, map1.get(key));
            }
        }
        return result + "}";
    }
}
