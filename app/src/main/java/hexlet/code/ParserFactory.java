package hexlet.code;

public class ParserFactory {
    public static final String JSON = "json";
    public static final String YAML = "yaml";
    public static final String YML = "yml";

    public static Parser getParser(String extension) {
        switch (extension) {
            case JSON -> {
                return new JsonParser();
            }
            case YAML, YML -> {
                return new YmlParser();
            }
            default -> throw new IllegalArgumentException("Unknown extension. Try again.");
        }
    }
}
