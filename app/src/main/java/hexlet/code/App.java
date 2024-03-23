package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "Diff", version = "1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {

    @Parameters(paramLabel = "filepath1", description = "path to first file")
        private String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
        private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
        String format;
    @Override
    public Object call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2));
        return null;
    }

    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
