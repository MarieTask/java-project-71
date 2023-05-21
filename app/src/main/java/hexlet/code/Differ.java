package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        // Создание файла:
        // Получаем путь к нужному файлу
        Path getFirstPath = Paths.get(filepath1); //Преобразует строку или строки, которые при соединении образуют строку пути, в объект класса Path.
        // Формируем абсолютный путь,
        // если filePath будет содержать относительный путь,
        // то мы всегда будет работать с абсолютным
        Path getAbsFirstPath = getFirstPath.toAbsolutePath().normalize();
        // Читаем файл
        String file1 = Files.readString(getAbsFirstPath); //переводим строку в данные (файл)
        ObjectMapper objectMapperFile1 = new ObjectMapper(); //создаем объект класса ObjectMapper
        // Метод readValue() используется для преобразования (десериализации) JSON из строки, потока или файла в POJO.
        // Usage is by sub-classing
        Map<String, Object> map1 = objectMapperFile1.readValue(file1, new TypeReference<Map<String,Object>>(){}); //JSON to Java Object

        Path getSecondPath = Paths.get(filepath2);
        Path getAbsSecondPath = getSecondPath.toAbsolutePath().normalize();
        String file2 = Files.readString(getAbsSecondPath);
        ObjectMapper objectMapperFile2 = new ObjectMapper();
        Map<String, Object> map2 = objectMapperFile2.readValue(file2, new TypeReference<Map<String,Object>>(){});

        Set<String> keyFile = new TreeSet<>(map1.keySet());
        keyFile.addAll(map2.keySet());

        String result = "{\n";
        for(String key: keyFile) {
            if (map1.containsKey(key) && map2.containsKey(key)) && Objects.equals(map1.get(key), map2.get(key)){
                result += String.format("");
            }
        }
    }
}
