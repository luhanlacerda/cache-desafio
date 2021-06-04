package lacerda.luhan.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lacerda.luhan.dto.UsuarioDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String nome;
    private String email;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Resultado> resultados;

    public Usuario() {
        this.resultados = new HashSet<>();
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.resultados = new HashSet<>();
    }

    public Usuario(UsuarioDTO usuarioDTO) {
        this.nome = usuarioDTO.getNome();
        this.email = usuarioDTO.getEmail();
        this.resultados = new HashSet<>();
    }

    public void addResultado(Resultado resultado) {
        this.resultados.add(resultado);
    }

}
