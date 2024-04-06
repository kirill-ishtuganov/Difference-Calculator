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

    public String getKey() {
        return key;
    }

    public String getStatus() {
        return status;
    }

    public Object getValue() {
        return value;
    }
}
