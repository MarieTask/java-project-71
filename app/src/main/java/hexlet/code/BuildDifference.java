package hexlet.code;

import java.util.*;

public class BuildDifference {
    public static List<Map<String,Object>> buildDifference (Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String,Object>> result = new ArrayList<>();

        Set<String> unionMap = new TreeSet<>(map1.keySet());
        unionMap.addAll(map2.keySet());
        List list = new ArrayList<>(unionMap);

        for (String key: unionMap) {
            //отображение с запоминанием порядка, в котором добавлялись элементы
            Map<String,Object> map = new LinkedHashMap<>();
            // No changes
            if (map1.containsKey(key) && map2.containsKey(key) && Objects.equals(map1.get(key), (map2.get(key)))) {
                map.put("key", key);
                map.put("Old value", map1.get(key));
                map.put("status", "no changes");
                // Key value was update
            } else if (map1.containsKey(key) && map2.containsKey(key) && !Objects.equals(map1.get(key), (map2.get(key)))) {
                map.put("key", key);
                map.put("Old value", map1.get(key));
                map.put("New value", map2.get(key));
                map.put("status", "updated");
                // Key was added
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                map.put("key", key);
                map.put("New value", map2.get(key));
                map.put("status", "added");
                // Key was deleted
            } else {
                map.put("key", key);
                map.put("Old value", map1.get(key));
                map.put("status", "deleted");
            }
            result.add(map);
        }
        return result;
    }
}
