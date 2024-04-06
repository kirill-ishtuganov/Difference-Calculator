package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.model.Data;
import java.util.ArrayList;

public class Formatter {

    public static String formatting(ArrayList<Data> diff, String formatName) throws Exception {

        return switch (formatName) {
            case "stylish" -> Stylish.formatting(diff);
            case "plain" -> Plain.formatting(diff);
            case "json" -> Json.formatting(diff);
            default -> throw new IllegalStateException("Unexpected value: " + formatName);
        };
    }
}
