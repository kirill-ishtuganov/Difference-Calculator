package hexlet.code.formatters.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {

    private String key;
    private String status;
    private Object value;

    public Data(String key, String status, Object value) {
        this.key = key;
        this.status = status;
        this.value = value;
    }
}
