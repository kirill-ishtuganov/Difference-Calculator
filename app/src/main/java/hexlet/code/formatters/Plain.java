package hexlet.code.formatters;

import hexlet.code.model.Data;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Plain {

    public static String formatting(ArrayList<Data> dataList) {

        StringJoiner joiner = new StringJoiner("\n");
        for (var data : dataList) {
            var key = data.getKey();
            var currentValue = getFormattedValue(data.getCurrentValue());
            var status = data.getStatus();
            switch (status) {
                case "removed":
                    joiner.add(getBeginning(key, status));
                    break;
                case "added":
                    joiner.add(getBeginning(key, status) + " with value: " + currentValue);
                    break;
                case "updated":
                    var oldValue = getFormattedValue(data.getOldValue());
                    joiner.add(getBeginning(key, status) + ". From " + oldValue + " to " + currentValue);
                    break;
                case "not changed":
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        return joiner.toString();
    }

    public static Object getFormattedValue(Object value) {

        if (value == null) {
            return value;
        }
        var stringValue = value.toString();
        if (stringValue.endsWith("]") || value.toString().endsWith("}")) {
            return "[complex value]";
        } else if (stringValue.equals("true") || stringValue.equals("false")) {
            return value;
        }
        try {
            Integer.parseInt(stringValue);
            return value;
        } catch (NumberFormatException e) {
            return "'" + stringValue + "'";
        }
    }

    public static String getBeginning(String key, String status) {
        return "Property '" + key + "' was " + status;
    }
}
