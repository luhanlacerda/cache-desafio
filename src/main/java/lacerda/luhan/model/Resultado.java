package lacerda.luhan.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String valorEntrada;
    private int qtdConcatenacao;
    private int resultado;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Resultado() {
        this.usuario = new Usuario();
    }

    public Resultado(String valorEntrada, int qtdConcatenacao, Usuario usuario) {
        this.valorEntrada = valorEntrada;
        this.qtdConcatenacao = qtdConcatenacao;
        this.usuario = usuario;
    }

    public void calcularDigitoUnico() {
        this.resultado = this.valorEntrada.repeat(this.qtdConcatenacao)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
