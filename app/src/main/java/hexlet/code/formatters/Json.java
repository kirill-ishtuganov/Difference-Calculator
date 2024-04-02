package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.formatters.model.Data;
import hexlet.code.formatters.model.Value;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Json {

    public static String formatting(LinkedHashMap<String, Object[]> diff) throws Exception {

        ArrayList<Data> dataList = new ArrayList<>();
        var entries = diff.entrySet();

        for (var entry : entries) {

            String key = entry.getKey();
            Object[] value = entry.getValue();
            String status = value[1].toString();

            switch (status) {
                case "removed", "added", "not changed":
                    dataList.add(new Data(key, status, value[0]));
                    break;
                case "updated":
                    dataList.add(new Data(key, status, new Value(value[0], value[2])));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(dataList);
    }
}
