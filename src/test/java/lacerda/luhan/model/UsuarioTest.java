package lacerda.luhan.model;

import lacerda.luhan.dto.UsuarioDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private static Resultado resultado;
    private static Usuario usuario;
    private static String nome;
    private static String email;

    @BeforeAll
    static void setup() {
        nome = "Usuario Teste";
        email = "email_teste@email.com";
        resultado = new Resultado();
        usuario = new Usuario(nome, email);
    }

    @Test
    void createUsuarioSuccessTest() {
        assertNotNull(this.usuario);
    }

    @Test
    void createUsuarioWithEmptyConstructorSuccessTest() {
        this.usuario = new Usuario();

        assertNotNull(this.usuario);
    }

    @Test
    void addResultadoInUsuarioSuccessTest() {
        this.usuario.addResultado(this.resultado);

        assertNotNull(this.usuario);
        assertTrue(this.usuario.getResultados().contains(this.resultado));
    }

    @Test
    void createUsuarioFromDTOSuccessTest() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setEmail(this.email);
        usuarioDTO.setNome(this.nome);
        this.usuario = new Usuario(usuarioDTO);

        assertNotNull(this.usuario);
        assertEquals(this.nome, this.usuario.getNome());
        assertEquals(this.email, this.usuario.getEmail());
    }

}
