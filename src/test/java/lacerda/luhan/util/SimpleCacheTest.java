package lacerda.luhan.util;

import lacerda.luhan.model.Resultado;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SimpleCacheTest {

    private static SimpleCache simpleCache;

    private static Resultado resultado;
    private static String valorEntrada;
    private static int qtdConcatenacao;

    @BeforeAll
    static void setup() {
        simpleCache = new SimpleCache();
        valorEntrada = "1010";
        qtdConcatenacao = 2;
        resultado = new Resultado(valorEntrada, qtdConcatenacao);
        resultado.calcularDigitoUnico();
    }

    @Test
    void getResultadoSuccessTest() {
        simpleCache.addElementInCache(resultado);
        assertEquals(resultado, simpleCache.getElement(resultado));
    }

    @Test
    void getResultadoUnsuccessTest() {
        assertNotEquals(resultado, simpleCache.getElement(resultado));
    }
}
