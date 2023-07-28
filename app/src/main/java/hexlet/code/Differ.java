package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;


public class Differ {

    // приведение пути к абсолютному
    public static Path getAbsolutePath(String path) {
        // Создание файла:
        // Получаем путь к нужному файлу
        // Преобразует строку или строки, которые при соединении образуют строку пути, в объект класса Path.
        // Формируем абсолютный путь,
        // если filePath будет содержать относительный путь,
        // то мы всегда будет работать с абсолютным
        return Paths.get(path).toAbsolutePath().normalize();
    }

    // прочтение данных по этому пути
    public static String getContent(String path) throws IOException {
        return Files.readString(getAbsolutePath(path));
    }

    // выбор парсера, исходя из расширения
    public static String getExtension(String path) {
        return path.substring(path.indexOf(".") + 1);
    }
    public static String generate(String path1, String path2, String extension) throws Exception {
        String content1 = getContent(path1);
        String extension1 = getExtension(path1);
        //Мы можем преобразовать JSON в Java Map, что очень удобно, если мы не знаем,
        //чего ожидать от файла JSON, который мы пытаемся спарсить.
        // ObjectMapper превратит имя каждой переменной в JSON в ключ для Map,
        // а значение этой переменной — в значение по этому ключу.
        Map<String, Object> map1 = Parser.parse(content1, extension1);
        //JSON to Java Object

        String content2 = getContent(path2);
        String extension2 = getExtension(path2);
        Map<String, Object> map2 = Parser.parse(content2, extension2);

        List<Map<String, Object>> data = BuildDifference.buildDifference(map1, map2);
        return Formatter.dataToRightFormat(data, extension);
    }
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
