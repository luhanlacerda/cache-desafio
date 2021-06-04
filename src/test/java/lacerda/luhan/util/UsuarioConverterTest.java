package lacerda.luhan.util;

import lacerda.luhan.dto.UsuarioDTO;
import lacerda.luhan.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioConverterTest {

    private static UsuarioDTO usuarioDTO;
    private static List<Usuario> users;

    @BeforeAll
    static void setup() {
        usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome("Nome");
        usuarioDTO.setEmail("email@email.com");
        users = new ArrayList<>();
    }

    @Test
    void convertUsersInDTOValidSuccessTest() throws Exception {
        users.add(new Usuario(usuarioDTO));
        List<UsuarioDTO> usersFromConverter;

        usersFromConverter = UsuarioConverter.buildUsuariosDTO(users);
        assertNotNull(usersFromConverter);
        assertTrue(!usersFromConverter.isEmpty());
    }

    @Test
    void isUsuarioDTOValidSuccessTest() throws Exception {
        assertNotNull(UsuarioConverter.isDTOValid(usuarioDTO));
    }

}
