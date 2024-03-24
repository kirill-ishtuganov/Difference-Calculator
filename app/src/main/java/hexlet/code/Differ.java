package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import static hexlet.code.Parser.parse;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {

        Map<String, Object> file1 = parse(filepath1);
        Map<String, Object> file2 = parse(filepath2);
        HashMap<String, Object> mergedContent = new HashMap<>(file1);
        mergedContent.putAll(file2);
        var entries = new TreeMap<>(mergedContent).entrySet();
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("{");

        for (var entry : entries) {
            var key = entry.getKey();
            if (file1.containsKey(key)) {
                if (file2.containsKey(key)) {
                    if (file1.get(key).equals(file2.get(key))) {
                        joiner.add(getBar(" ", key, entry.getValue()));
                    } else {
                        joiner.add(getBar("-", key, file1.get(key)));
                        joiner.add(getBar("+", key, file2.get(key)));
                    }
                } else {
                    joiner.add(getBar("-", key, file1.get(key)));
                }
            } else {
                joiner.add(getBar("+", key, file2.get(key)));
            }
        }
        joiner.add("}");
        return joiner.toString();
    }

    public static String getBar(String symbol, String key, Object value) {
        return "  " + symbol + " " + key + ": " + value;
    }
}
