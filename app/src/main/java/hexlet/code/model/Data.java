package hexlet.code.model;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Data {

    private String key;
    private String status;
    private Object oldValue;
    private Object currentValue;

    public Data(String key, String status, Object currentValue) {
        this.key = key;
        this.status = status;
        this.currentValue = currentValue;
    }

    public final String getKey() {
        return key;
    }

    public final String getStatus() {
        return status;
    }

    public final Object getOldValue() {
        return oldValue;
    }

    public final Object getCurrentValue() {
        return currentValue;
    }
}
