package lacerda.luhan.util;

import com.google.gson.JsonObject;
import lacerda.luhan.model.Resultado;
import lacerda.luhan.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResultadoConverterTest {

    private static String jsonEntrada;
    private static JsonObject jsonObject;
    private Resultado resultado;
    private static Usuario usuario;

    @BeforeAll
    static void setup() {
        jsonEntrada = "{\n" +
                "\t\"nome\":\"teste\",\n" +
                "\t\"valorEntrada\": \"1010\",\n" +
                "\t\"qtdConcatenacao\": 2\n" +
                "}";
        jsonObject = JsonConverterUtils.convertToJsonObject(jsonEntrada);
        usuario = new Usuario();
    }

    @Test
    void convertStringToJsonObjectSuccessTest() throws Exception {
        this.resultado = ResultadoConverter.buildResultado(jsonObject, usuario);
        assertNotNull(resultado);
        assertNotNull(ResultadoConverter.buildResultado(jsonObject, usuario));
        assertEquals("1010", resultado.getValorEntrada());
        assertEquals(2, resultado.getQtdConcatenacao());
    }

}
