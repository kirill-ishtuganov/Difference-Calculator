package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class Stylish {

    public static String formatting(LinkedHashMap<String, Object[]> diff) {

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
                case "not changed":
                    joiner.add(getBar(" ", key, value[0]));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        joiner.add("}");
        return joiner.toString();
    }

    public static String getBar(String symbol, String key, Object value) {
        return "  " + symbol + " " + key + ": " + value;
    }
}
