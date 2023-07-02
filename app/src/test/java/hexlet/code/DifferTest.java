package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    private static String defaultFormat = "stylish";
    private static String jsonFile1;
    private static String jsonFile2;
    private static String jsonParsingResult;
    private static String yamlFile1;
    private static String yamlFile2;
    private static String yamlParsingResult;
    @BeforeAll
    public static void beforeAll() throws Exception {
        jsonFile1 = "./src/test/resources/file1.json";
        jsonFile2 = "./src/test/resources/file2.json";
        jsonParsingResult = Files.readString(Paths.get("./src/test/resources/jsonParsingResult"));
        yamlFile1 = "./src/test/resources/file1.json";
        yamlFile2 = "./src/test/resources/file2.json";
        yamlParsingResult = Files.readString(Paths.get("./src/test/resources/yamlParsingResult"));
    }
    @Test
    public void testDefaultFormat() throws Exception {
        String jsonResult = Differ.generate(jsonFile1, jsonFile2);
        assertThat(jsonResult).isEqualTo(jsonParsingResult);
        String yamlResult = Differ.generate(yamlFile1, yamlFile2);
        assertThat(yamlResult).isEqualTo(yamlParsingResult);
    }
    @Test
    public void testStylishFormat() throws Exception {
        String jsonResult = Differ.generate(jsonFile1, jsonFile2, defaultFormat);
        assertThat(jsonResult).isEqualTo(jsonParsingResult);
        String yamlResult = Differ.generate(yamlFile1, yamlFile2, defaultFormat);
        assertThat(yamlResult).isEqualTo(yamlParsingResult);
    }
}
