package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String filepath) throws Exception {

        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        return filepath.endsWith("json") ? parseJSON(content) : parseYAML(content);
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
