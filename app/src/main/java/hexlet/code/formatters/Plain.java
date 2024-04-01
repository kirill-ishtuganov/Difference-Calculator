package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class Plain {

    public static String formatting(LinkedHashMap<String, Object[]> diff) {

        var entries = diff.entrySet();
        StringJoiner joiner = new StringJoiner("\n");
        for (var entry : entries) {
            var key = entry.getKey();
            Object[] value = entry.getValue();
            String status = value[1].toString();
            Object value1 = getFormattedValue(value[0]);
            switch (status) {
                case "removed":
                    joiner.add(getBeginning(key, status));
                    break;
                case "added":
                    joiner.add(getBeginning(key, status) + " with value: " + value1);
                    break;
                case "updated":
                    Object value2 = getFormattedValue(value[2]);
                    joiner.add(getBeginning(key, status) + ". From " + value1 + " to " + value2);
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

        var stringValue = value.toString();

        if (stringValue.endsWith("]") || value.toString().endsWith("}")) {
            return "[complex value]";
        } else if (stringValue.equals("true") || stringValue.equals("false") || stringValue.equals("null")) {
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
