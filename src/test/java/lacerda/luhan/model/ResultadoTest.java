package lacerda.luhan.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class ResultadoTest {

    @Autowired
    Resultado resultado;

    String valorEntrada;
    int qtdConcatenacao;

    @BeforeEach
    void setup() {
        valorEntrada = "1010";
        qtdConcatenacao = 2;
        this.resultado = new Resultado(valorEntrada, qtdConcatenacao);
    }

    @Test
    void calcularDigitoUnicoSuccessTest() {
        this.resultado.calcularDigitoUnico();
        assertEquals(4, resultado.getResultado());
    }

    @Test
    void calcularDigitoUnicoUnsuccessTest() {
        this.resultado.calcularDigitoUnico();
        assertNotEquals(2, resultado.getResultado());
    }

}
