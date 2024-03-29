package hexlet.code;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.Objects;


public class DiffBuilder {
    public static List<Map<String, Object>> build(Map<String, Object> data1, Map<String, Object> data2) {
        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key: keys) {
            //отображение с запоминанием порядка, в котором добавлялись элементы
            Map<String, Object> data = new LinkedHashMap<>();
                // Key was added
            if (!data1.containsKey(key) && data2.containsKey(key)) {
                data.put("key", key);
                data.put("new_value", data2.get(key));
                data.put("status", "added");
                // Key was deleted
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                data.put("key", key);
                data.put("old_value", data1.get(key));
                data.put("status", "deleted");
                // Key value was update
            } else if (data1.containsKey(key) && data2.containsKey(key) && !Objects.equals(data1.get(key),
                    (data2.get(key)))) {
                data.put("key", key);
                data.put("old_value", data1.get(key));
                data.put("new_value", data2.get(key));
                data.put("status", "changed");
                // No changes
            } else {
                data.put("key", key);
                data.put("old_value", data1.get(key));
                data.put("status", "unchanged");
            }
            result.add(data);
        }
        return result;
    }
}
