package hexlet.code.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static String getFileFormat(String filepath) {

        String[] filepathParts = filepath.split("/");
        String file = filepathParts[filepathParts.length - 1];
        return file.split("\\.")[1];
    }

    public static String getUnparsedString(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
