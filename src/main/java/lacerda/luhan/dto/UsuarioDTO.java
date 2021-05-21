package lacerda.luhan.dto;

import lacerda.luhan.model.Resultado;
import lacerda.luhan.model.Usuario;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private Set<Resultado> resultados;

    public UsuarioDTO() {
        this.resultados = new HashSet<>();
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.resultados = usuario.getResultados();
    }
}
