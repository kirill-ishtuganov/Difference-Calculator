package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "Diff", version = "1.0", mixinStandardHelpOptions = true)
public class App implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello, world!");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}