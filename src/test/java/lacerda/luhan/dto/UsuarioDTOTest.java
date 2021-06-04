package lacerda.luhan.dto;

import lacerda.luhan.model.Resultado;
import lacerda.luhan.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioDTOTest {

    private static Set<Resultado> resultados;
    private static Usuario usuario;
    private static UsuarioDTO usuarioDTO;
    private static String nome;
    private static String email;

    @BeforeAll
    static void setup() {
        nome = "Usuario Teste";
        email = "email_teste@email.com";
        String valorEntrada = "1010";
        int qtdConcatenacao = 2;
        resultados = Set.of(new Resultado(valorEntrada, qtdConcatenacao));
        usuario = new Usuario(nome, email);
    }

    @Test
    void createUsuarioDTOWithEmptyConstructorSuccessTest() {
        usuarioDTO = new UsuarioDTO();

        assertNotNull(usuarioDTO);
    }

    @Test
    void createUsuarioDTOWithAllArgsConstructorSuccessTest() {
        usuarioDTO = new UsuarioDTO(usuario);

        assertNotNull(usuarioDTO);
        assertEquals(usuario.getNome(), usuarioDTO.getNome());
        assertEquals(usuario.getEmail(), usuarioDTO.getEmail());
    }
}
