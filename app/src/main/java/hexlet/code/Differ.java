package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;


public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String fileContent1 = getFileContent(filepath1);
        String fileFormat1 = getFileFormat(filepath1);
        //Мы можем преобразовать JSON в Java Map, что очень удобно, если мы не знаем,
        //чего ожидать от файла JSON, который мы пытаемся спарсить.
        // ObjectMapper превратит имя каждой переменной в JSON в ключ для Map,
        // а значение этой переменной — в значение по этому ключу.
        Map<String, Object> map1 = Parser.parse(fileContent1, fileFormat1);
        //JSON to Java Object

        String fileContent2 = getFileContent(filepath2);
        String fileFormat2 = getFileFormat(filepath2);
        Map<String, Object> map2 = Parser.parse(fileContent2, fileFormat2);

        List<Map<String, Object>> data = BuildDifference.buildDifference(map1, map2);
        return Formatter.dataToRightFormat(data, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
    public static Path getAbsolutePath(String filepath) {
        // Создание файла:
        // Получаем путь к нужному файлу
        Path pathFile = Paths.get(filepath);
        // Преобразует строку или строки, которые при соединении образуют строку пути, в объект класса Path.
        // Формируем абсолютный путь,
        // если filePath будет содержать относительный путь,
        // то мы всегда будет работать с абсолютным
        return pathFile.toAbsolutePath().normalize();
    }
    public static String getFileFormat(String filepath) {
        String absPath = getAbsolutePath(filepath).toString();
        return absPath.substring(absPath.indexOf(".") + 1);
    }
    public static String getFileContent(String filepath) throws IOException {
        return Files.readString(getAbsolutePath(filepath));
    }
}
