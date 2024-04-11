package hexlet.code.model;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Data {

    private String key;
    private Status status;
    private Object oldValue;
    private Object currentValue;

    public Data(String key, Status status, Object currentValue) {
        this.key = key;
        this.status = status;
        this.currentValue = currentValue;
    }

    public final String getKey() {
        return key;
    }

    public final Status getStatus() {
        return status;
    }

    public final Object getOldValue() {
        return oldValue;
    }

    public final Object getCurrentValue() {
        return currentValue;
    }
}
