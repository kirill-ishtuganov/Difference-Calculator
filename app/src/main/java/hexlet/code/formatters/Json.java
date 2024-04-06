package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.model.Data;

import java.util.ArrayList;

public class Json {

    public static String formatting(ArrayList<Data>  dataList) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(dataList);
    }
}
