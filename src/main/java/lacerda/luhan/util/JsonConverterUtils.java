package lacerda.luhan.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonConverterUtils {

    private JsonConverterUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static JsonObject convertToJsonObject(String param) {
        return new Gson().fromJson(param, JsonObject.class);
    }

    public static String getStringJsonValue(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsString();
    }

    public static int getIntJsonValue(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsInt();
    }

}
