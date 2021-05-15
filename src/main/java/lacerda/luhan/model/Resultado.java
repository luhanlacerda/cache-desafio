package lacerda.luhan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {
    private String valorEntrada;
    private int numeroConcatenacao;
    private int resultado;
}
