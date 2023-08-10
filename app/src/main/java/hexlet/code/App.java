package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {
    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String path1;
    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String path2;
    @Option(names = {"-f", "--format"}, paramLabel = "format", defaultValue = "stylish",
            description = "output format [default: stylish]")
    private String extension;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean usageHelpRequested;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean versionInfoRequested;

    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;
    @Override
    public Integer call() {
        try {
            System.out.println(Differ.generate(path1, path2, extension));
            return SUCCESS_EXIT_CODE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
