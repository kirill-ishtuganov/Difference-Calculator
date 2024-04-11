package hexlet.code.formatters;

import hexlet.code.model.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Plain {

    public static String formatting(ArrayList<Data> dataList) {

        StringJoiner joiner = new StringJoiner("\n");
        for (var data : dataList) {
            var key = data.getKey();
            var currentValue = prepareValue(data.getCurrentValue());
            var status = data.getStatus();
            switch (status) {
                case REMOVED:
                    joiner.add(formatBeginning(key, "removed"));
                    break;
                case ADDED:
                    joiner.add(formatBeginning(key, "added") + " with value: " + currentValue);
                    break;
                case UPDATED:
                    var oldValue = prepareValue(data.getOldValue());
                    joiner.add(formatBeginning(key, "updated") + ". From " + oldValue + " to " + currentValue);
                    break;
                case UNCHANGED:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        return joiner.toString();
    }

    public static Object prepareValue(Object value) {

        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }

    public static String formatBeginning(String key, String status) {
        return "Property '" + key + "' was " + status;
    }
}
