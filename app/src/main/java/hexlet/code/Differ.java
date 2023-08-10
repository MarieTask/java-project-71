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
        String absPath = String.valueOf(getAbsolutePath(path));
        return absPath.substring(absPath.lastIndexOf(".") + 1);
    }
    public static Map<String, Object> getData(String path) throws Exception {
        String content = getContent(path);
        String extension = getExtension(path);
        //Мы можем преобразовать JSON в Java Map, что очень удобно, если мы не знаем,
        //чего ожидать от файла JSON, который мы пытаемся спарсить.
        // ObjectMapper превратит имя каждой переменной в JSON в ключ для Map,
        // а значение этой переменной — в значение по этому ключу.
        return ParserFactory.getParser(extension).parse(content);
    }
    public static String generate(String content1, String content2) throws Exception {
        return generate(content1, content2, "stylish");
    }
    public static String generate(String content1, String content2, String extension) throws Exception {
        List<Map<String, Object>> data = DiffBuilder.build(getData(content1), getData(content2));
        return Formatter.dataToRightFormat(data, extension);
    }
}
