package lacerda.luhan.util;

import com.google.gson.JsonObject;
import lacerda.luhan.model.Resultado;
import lacerda.luhan.model.Usuario;

public class ResultadoConverter {
    private static final String VALOR_ENTRADA_JSON_KEY = "valorEntrada";
    private static final String QTD_CONCATENACAO_JSON_KEY = "qtdConcatenacao";


    private ResultadoConverter() {
        throw new IllegalStateException("Utility class");
    }

    public static Resultado buildResultado(JsonObject json, Usuario usuario) {
        String valorEntrada = JsonConverterUtils.getStringJsonValue(json, VALOR_ENTRADA_JSON_KEY);
        int qtdConcatenacao = JsonConverterUtils.getIntJsonValue(json, QTD_CONCATENACAO_JSON_KEY);
        return new Resultado(valorEntrada, qtdConcatenacao, usuario);
    }

}
