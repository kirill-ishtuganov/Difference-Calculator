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
        var format = getFinaleFileFormat(path.toString());

        return switch (format) {
            case "yml" -> parseYAML(content);
            default -> parseJSON(content);
        };
    }

    public static String getFinaleFileFormat(String filepath) {

        String[] filepathParts = filepath.split("/");
        String file = filepathParts[filepathParts.length - 1];
        return file.split("\\.")[1];
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
