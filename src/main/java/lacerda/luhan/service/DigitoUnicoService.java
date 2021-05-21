package lacerda.luhan.service;

import lacerda.luhan.model.Resultado;
import org.springframework.stereotype.Component;

@Component
public class DigitoUnicoService {

    public int calcularDigitoUnico(String value, int concatenationNumber) {
        return value.repeat(concatenationNumber)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

    public int calcularDigitoUnico(Resultado resultado) {
        return resultado.getValorEntrada().repeat(resultado.getQtdConcatenacao())
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

}
