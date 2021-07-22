package by.bntu.fitr.json;

import org.json.JSONObject;

import javax.json.JsonObject;
import java.util.List;

@FunctionalInterface
public interface JSONObjectHandler<T> {
    public JSONObject objectHandle(T object);
}
