package hexlet.code.formatters;

import hexlet.code.model.Data;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Stylish {

    public static String formatting(ArrayList<Data> dataList) {

        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("{");
        for (var data : dataList) {
            var key = data.getKey();
            var currentValue = data.getCurrentValue();

            switch (data.getStatus()) {
                case REMOVED:
                    joiner.add(formatLine("-", key, currentValue));
                    break;
                case ADDED:
                    joiner.add(formatLine("+", key, currentValue));
                    break;
                case UPDATED:
                    var oldValue = data.getOldValue();
                    joiner.add(formatLine("-", key, oldValue));
                    joiner.add(formatLine("+", key, currentValue));
                    break;
                case UNCHANGED:
                    joiner.add(formatLine(" ", key, currentValue));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + data.getStatus());
            }
        }
        joiner.add("}");
        return joiner.toString();
    }

    public static String formatLine(String symbol, String key, Object value) {
        return "  " + symbol + " " + key + ": " + value;
    }
}
