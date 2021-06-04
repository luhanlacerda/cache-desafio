package lacerda.luhan.util;

import lacerda.luhan.dto.UsuarioDTO;
import lacerda.luhan.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioConverter {

    private UsuarioConverter() {
        throw new IllegalStateException("Utility class");
    }

    public static List<UsuarioDTO> buildUsuariosDTO(List<Usuario> usuarioList) {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        usuarioList.forEach(usuario -> usuariosDTO.add(new UsuarioDTO(usuario)));
        return usuariosDTO;
    }

    public static boolean isDTOValid(UsuarioDTO usuarioDTO) throws Exception {
        try {
            return !usuarioDTO.getNome().isEmpty() && !usuarioDTO.getEmail().isEmpty();
        } catch (Exception e) {
            throw new Exception("Erro ao validar a classe DTO - " + e.getMessage());
        }
    }

}
