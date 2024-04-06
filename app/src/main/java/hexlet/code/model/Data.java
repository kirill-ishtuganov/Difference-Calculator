package hexlet.code.model;

import lombok.Setter;

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

    public final String getKey() {
        return key;
    }

    public final String getStatus() {
        return status;
    }

    public final Object getValue() {
        return value;
    }
}
