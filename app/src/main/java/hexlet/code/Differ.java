package hexlet.code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import static hexlet.code.Parser.parse;

public class Differ {

    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {

        Map<String, Object> file1 = parse(filepath1);
        Map<String, Object> file2 = parse(filepath2);
        return Formatter.formatting(putInOrder(file1, file2), formatName);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static LinkedHashMap<String, Object[]> putInOrder(Map<String, Object> file1, Map<String, Object> file2) {

        HashMap<String, Object> mergedContent = new HashMap<>(file1);
        mergedContent.putAll(file2);
        var entries = new TreeMap<>(mergedContent).entrySet();
        LinkedHashMap<String, Object[]> result = new LinkedHashMap<>();
        for (var entry : entries) {
            var key = entry.getKey();
            var value1 = file1.get(key) == null ? "null" : file1.get(key);
            var value2 = file2.get(key) == null ? "null" : file2.get(key);
            if (file1.containsKey(key)) {
                if (file2.containsKey(key)) {
                    if (value1.equals(value2)) {
                        result.put(key, new Object[]{entry.getValue(), "not changed"});
                    } else {
                        result.put(key, new Object[]{value1, "updated", value2});
                    }
                } else {
                    result.put(key, new Object[]{value1, "removed"});
                }
            } else {
                result.put(key, new Object[]{value2, "added"});
            }
        }
        return result;
    }
}
