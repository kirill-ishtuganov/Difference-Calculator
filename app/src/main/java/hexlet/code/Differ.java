package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {

        Map<String, Object> file1 = getData(filepath1);
        Map<String, Object> file2 = getData(filepath2);

        HashMap<String, Object> mergedContent= new HashMap<>();
        mergedContent.putAll(file1);
        mergedContent.putAll(file2);
        var entries = new TreeMap<>(mergedContent).entrySet();
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("{");

        for (var entry : entries) {
            var key = entry.getKey();
            var value = entry.getValue();
            if(file1.containsKey(key)) {
                if (file2.containsKey(key)) {
                    if (file1.get(key).equals(file2.get(key))) {
                        joiner.add(getBar(" ", key, value));
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

    public static Map<String,Object> getData(String filePath) throws Exception {

        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() {
        });
    }
}
