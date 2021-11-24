package rocks.voss.jsonhelper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class JSONHelper {
    public static <T> T createBean(Class<T> clazz, InputStream stream) throws IOException {
        String json = IOUtils.toString(stream, "UTF-8");
        return createBean(clazz, json);
    }

    public static <T> T createBean(Class<T> clazz, String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonNode jsonNode = mapper.readValue(json, JsonNode.class);
        return mapper.treeToValue(jsonNode, clazz);
    }

    public static <T> T createBean(Class<T> clazz, Object obj) throws IOException {
        String jsonString = getJsonString(obj);
        return createBean(clazz, jsonString);
    }

    private static JsonNode getJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode returnJson = mapper.valueToTree(object);
        return returnJson;
    }

    public static String getJsonString(Object object) {
        return getJson(object).toString();
    }
}
