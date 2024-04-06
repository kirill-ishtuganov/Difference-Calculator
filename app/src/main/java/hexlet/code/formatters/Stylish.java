package hexlet.code.formatters;

import hexlet.code.model.Data;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringJoiner;

public class Stylish {

    public static String formatting(ArrayList<Data> dataList) {

        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("{");
        for (var data : dataList) {
            var key = data.getKey();
            var value = data.getValue();
            switch (data.getStatus()) {
                case "removed":
                    joiner.add(getBar("-", key, value));
                    break;
                case "added":
                    joiner.add(getBar("+", key, value));
                    break;
                case "updated":
                    Map values = (Map) value;
                    joiner.add(getBar("-", key, values.get("oldValue")));
                    joiner.add(getBar("+", key, values.get("newValue")));
                    break;
                case "not changed":
                    joiner.add(getBar(" ", key, value));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + data.getStatus());
            }
        }
        joiner.add("}");
        return joiner.toString();
    }

    public static String getBar(String symbol, String key, Object value) {
        return "  " + symbol + " " + key + ": " + value;
    }
}
