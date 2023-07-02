package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    private static final String DEFAULT_FORMAT = "stylish";
    private static final String JSON = "json";
    private static final String YAML = "yaml";
    private static final String YML = "yml";
    private static String jsonFile1;
    private static String jsonFile2;
    private static String yamlFile1;
    private static String yamlFile2;
    private static String yamlParsingResult;
    private static String stylishParsingResult;
    private static String jsonParsingResult;
    @BeforeAll
    public static void beforeAll() throws Exception {
        jsonFile1 = "./src/test/resources/file1.json";
        jsonFile2 = "./src/test/resources/file2.json";
        yamlFile1 = "./src/test/resources/file1.json";
        yamlFile2 = "./src/test/resources/file2.json";
        stylishParsingResult = Files.readString(Paths.get("./src/test/resources/stylishParsingResult"));
        jsonParsingResult = Files.readString(Paths.get("./src/test/resources/jsonParsingResult"));
        yamlParsingResult = Files.readString(Paths.get("./src/test/resources/ymlParsingResult"));
    }
    @Test
    public void testDefaultFormat() throws Exception {
        String jsonResult = Differ.generate(jsonFile1, jsonFile2);
        assertThat(jsonResult).isEqualTo(stylishParsingResult);
        String yamlResult = Differ.generate(yamlFile1, yamlFile2);
        assertThat(yamlResult).isEqualTo(stylishParsingResult);
    }
    @Test
    public void testStylishFormat() throws Exception {
        String jsonResult = Differ.generate(jsonFile1, jsonFile2, DEFAULT_FORMAT);
        assertThat(jsonResult).isEqualTo(stylishParsingResult);
        String yamlResult = Differ.generate(yamlFile1, yamlFile2, DEFAULT_FORMAT);
        assertThat(yamlResult).isEqualTo(stylishParsingResult);
    }
    @Test
    public void testJsonFormat() throws Exception {
        String jsonResult = Differ.generate(jsonFile1, jsonFile2, JSON);
        assertThat(jsonResult).isEqualTo(jsonParsingResult);
        String yamlResult = Differ.generate(yamlFile1, yamlFile2, JSON);
        assertThat(yamlResult).isEqualTo(jsonParsingResult);
    }
    @Test
    public void testYamlFormat() throws Exception {
        String jsonResult = Differ.generate(jsonFile1, jsonFile2, YAML);
        assertThat(jsonResult).isEqualTo(yamlParsingResult);
        String yamlResult = Differ.generate(yamlFile1, yamlFile2, YAML);
        assertThat(yamlResult).isEqualTo(yamlParsingResult);
    }
    @Test
    public void testYmlFormat() throws Exception {
        String jsonResult = Differ.generate(jsonFile1, jsonFile2, YML);
        assertThat(jsonResult).isEqualTo(yamlParsingResult);
        String yamlResult = Differ.generate(yamlFile1, yamlFile2, YML);
        assertThat(yamlResult).isEqualTo(yamlParsingResult);
    }
}
