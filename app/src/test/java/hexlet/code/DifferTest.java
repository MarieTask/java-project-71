package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    private final String DEFAULT_FORMAT = "stylish";
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
/*    @Test
    public void testDefaultFormat() throws Exception {
        String jsonResult = Differ.generate(jsonFile1, jsonFile2); // написать перегрузку метода
        assertThat(jsonResult).isEqualTo(jsonParsingResult);
        String yamlResult = Differ.generate(yamlFile1, yamlFile2); // написать перегрузку метода
        assertThat(yamlResult).isEqualTo(yamlParsingResult);
    }
 */
    @Test
    public void testStylishFormat() throws Exception {
        String jsonResult = Differ.generate(jsonFile1, jsonFile2, DEFAULT_FORMAT);
        assertThat(jsonResult).isEqualTo(jsonParsingResult);
        String yamlResult = Differ.generate(yamlFile1, yamlFile2, DEFAULT_FORMAT);
        assertThat(yamlResult).isEqualTo(yamlParsingResult);
    }
}
