package hexlet.code;

import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class Formatter {

    public static String formatting(LinkedHashMap<String, Object[]> diff, String format) {

        return switch (format) {
            default -> formattingStylish(diff);
        };
    }

    public static String formattingStylish(LinkedHashMap<String, Object[]> diff) {

        var entries = diff.entrySet();
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("{");

        for (var entry : entries) {

            var key = entry.getKey();
            Object[] value = entry.getValue();
            String status = value[1].toString();

            switch (status) {
                case "removed":
                    joiner.add(getBar("-", key, value[0]));
                    break;
                case "added":
                    joiner.add(getBar("+", key, value[0]));
                    break;
                case "updated":
                    joiner.add(getBar("-", key, value[0]));
                    joiner.add(getBar("+", key, value[2]));
                    break;
                default:
                    joiner.add(getBar(" ", key, value[0]));
            }
        }
        joiner.add("}");
        return joiner.toString();
    }

    public static String getBar(String symbol, String key, Object value) {
        return "  " + symbol + " " + key + ": " + value;
    }
}
