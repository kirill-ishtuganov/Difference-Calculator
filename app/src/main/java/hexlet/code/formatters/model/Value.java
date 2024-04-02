package hexlet.code.formatters.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Value {

    private Object oldValue;
    private Object newValue;

    public Value(Object oldValue, Object newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
}
