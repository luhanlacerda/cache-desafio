package lacerda.luhan.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Setter(AccessLevel.NONE)
    private Long id;
    private String nome;
    private String email;
    private List<Resultado> resultados;

    public User() {
        this.resultados = new ArrayList<>();
    }


}
