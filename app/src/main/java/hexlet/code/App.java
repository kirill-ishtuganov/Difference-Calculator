package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "Diff", version = "1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

    @Parameters(paramLabel = "filepath1", description = "path to first file")
        private String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
        private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
        int format;
    @Override
    public void run() {
        System.out.println("Hello, world!");
    }

    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}