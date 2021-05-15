package lacerda.luhan.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String valorEntrada;
    private int numeroConcatenacao;
    private int resultado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = true, updatable = true)
    @JsonView
    private Usuario usuario;
}
