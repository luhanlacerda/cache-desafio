package lacerda.luhan.util;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JsonConverterUtilsTest {

    private static String jsonEntrada;

    @BeforeAll
    static void setup() {
        jsonEntrada = "{\n" +
                "\t\"nome\":\"teste\",\n" +
                "\t\"valorEntrada\": \"1010\",\n" +
                "\t\"qtdConcatenacao\": 2\n" +
                "}";
    }

    @Test
    void convertStringToJsonObjectSuccessTest() {
        JsonObject jsonObject = JsonConverterUtils.convertToJsonObject(jsonEntrada);
        assertNotNull(jsonObject);
    }

    @Test
    void convertStringToJsonObjectNotSuccessTest() {
        JsonObject jsonObject = JsonConverterUtils.convertToJsonObject("");
        assertNull(jsonObject);
    }

    @Test
    void getStringJsonValueSuccessTest() {
        JsonObject jsonObject = JsonConverterUtils.convertToJsonObject(jsonEntrada);
        String stringNomeJsonValue = JsonConverterUtils.getStringJsonValue(jsonObject, "nome");
        assertNotNull(stringNomeJsonValue);
        assertEquals("teste", stringNomeJsonValue);
    }

    @Test
    void getIntJsonValueSuccessTest() {
        JsonObject jsonObject = JsonConverterUtils.convertToJsonObject(jsonEntrada);
        int intJsonValue = JsonConverterUtils.getIntJsonValue(jsonObject, "qtdConcatenacao");
        assertNotNull(intJsonValue);
        assertEquals(2, intJsonValue);
    }
}
