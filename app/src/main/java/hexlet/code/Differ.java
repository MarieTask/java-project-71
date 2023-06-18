package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        // Создание файла:
        // Получаем путь к нужному файлу
        Path getFirstPath = Paths.get(filepath1);
        // Преобразует строку или строки, которые при соединении образуют строку пути, в объект класса Path.
        // Формируем абсолютный путь,
        // если filePath будет содержать относительный путь,
        // то мы всегда будет работать с абсолютным
        Path getAbsFirstPath = getFirstPath.toAbsolutePath().normalize();
        // Читаем файл
        String file1 = Files.readString(getAbsFirstPath); //переводим строку в данные (файл)
        // Создайте объект ObjectMapper, который является основным классом для обработки JSON-данных в Jackson:
        ObjectMapper objectMapperFile1 = new ObjectMapper();
        // Используйте метод readValue() для чтения JSON-файла и преобразования его в объект Java:
        // Метод readValue() используется для преобразования (десериализации) JSON из строки, потока или файла в POJO.

        //Мы можем преобразовать JSON в Java Map, что очень удобно, если мы не знаем,
        //чего ожидать от файла JSON, который мы пытаемся спарсить.
        // ObjectMapper превратит имя каждой переменной в JSON в ключ для Map,
        // а значение этой переменной — в значение по этому ключу.
        Map<String, Object> map1 = objectMapperFile1.readValue(file1, new TypeReference<Map<String, Object>>() { });
        //JSON to Java Object

        Path getSecondPath = Paths.get(filepath2);
        Path getAbsSecondPath = getSecondPath.toAbsolutePath().normalize();
        String file2 = Files.readString(getAbsSecondPath);
        ObjectMapper objectMapperFile2 = new ObjectMapper();
        Map<String, Object> map2 = objectMapperFile2.readValue(file2, new TypeReference<Map<String, Object>>() { });

        Set<String> keyFile = new TreeSet<>(map1.keySet());
        keyFile.addAll(map2.keySet());

        String result = "{\n";
        for (String key: keyFile) {
            // No changes
            if (map1.containsKey(key) && map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
                result += String.format("      %s: %s\n", key, map1.get(key));
                // Key value was update
            } else if (map1.containsKey(key) && map2.containsKey(key) && !map1.get(key).equals(map2.get(key))) {
                result += String.format("    - %s: %s\n    + %s: %s\n", key, map1.get(key), key, map2.get(key));
                // Key was added
            } else if (!map1.containsKey(key)) {
                result += String.format("    + %s: %s\n", key, map2.get(key));
                // Key was deleted
            } else {
                result += String.format("    - %s: %s\n", key, map1.get(key));
            }
        }
        return result + "}";
    }
}
