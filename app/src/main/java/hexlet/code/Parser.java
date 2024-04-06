package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String fileFormat) throws Exception {

        return switch (fileFormat) {
            case "yml" -> parseYAML(content);
            case "json" -> parseJSON(content);
            default -> throw new IllegalStateException("Unexpected value: " + fileFormat);
        };
    }

    public static Map<String, Object> parseYAML(String content) throws Exception {

        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(content, new TypeReference<>() { });
    }

    public static Map<String, Object> parseJSON(String content) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() { });
    }
}
