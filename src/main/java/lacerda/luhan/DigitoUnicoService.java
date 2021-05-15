package lacerda.luhan;

import org.springframework.stereotype.Component;

@Component
public class DigitoUnicoService {

    public int calcularDigitoUnico(String value, int concatenationNumber) {
        return value.repeat(concatenationNumber)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

}
