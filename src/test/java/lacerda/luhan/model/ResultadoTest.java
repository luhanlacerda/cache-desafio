package lacerda.luhan.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class ResultadoTest {

    private static Resultado resultado;

    private static String valorEntrada;
    private static int qtdConcatenacao;

    @BeforeAll
    static void setup() {
        valorEntrada = "1010";
        qtdConcatenacao = 2;
        resultado = new Resultado(valorEntrada, qtdConcatenacao);
    }

    @Test
    void calcularDigitoUnicoSuccessTest() {
        this.resultado.calcularDigitoUnico();
        assertEquals(4, resultado.getResultado());
    }

    @Test
    void calcularDigitoUnicoWithUsuarioInConstructorSuccessTest() {
        this.resultado = new Resultado(valorEntrada, qtdConcatenacao, new Usuario());
        this.resultado.calcularDigitoUnico();
        assertEquals(4, resultado.getResultado());
    }

    @Test
    void calcularDigitoUnicoWithEmptyConstructorSuccessTest() {
        this.resultado = new Resultado();
        this.resultado.setValorEntrada(valorEntrada);
        this.resultado.setQtdConcatenacao(qtdConcatenacao);
        this.resultado.calcularDigitoUnico();
        assertEquals(4, resultado.getResultado());
    }

    @Test
    void calcularDigitoUnicoUnsuccessTest() {
        this.resultado.calcularDigitoUnico();
        assertNotEquals(2, resultado.getResultado());
    }


}
