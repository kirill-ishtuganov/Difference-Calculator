package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.LinkedHashMap;

public class Formatter {

    public static String formatting(LinkedHashMap<String, Object[]> diff, String formatName) {

        return switch (formatName) {
            case "stylish" -> Stylish.formatting(diff);
            case "plain" -> Plain.formatting(diff);
            default -> throw new IllegalStateException("Unexpected value: " + formatName);
        };
    }
}
