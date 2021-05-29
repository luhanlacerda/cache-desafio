package lacerda.luhan.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lacerda.luhan.dto.UsuarioDTO;
import lacerda.luhan.model.Resultado;
import lacerda.luhan.model.Usuario;
import lacerda.luhan.repository.ResultadoRepository;
import lacerda.luhan.repository.UsuarioRepository;
import lacerda.luhan.util.JsonConverterUtils;
import lacerda.luhan.util.ResultadoConverter;
import lacerda.luhan.util.UsuarioConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    private static final String NOME_USUARIO_JSON_KEY = "nome";

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private ResultadoRepository resultadoRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsuarios() {
        try {
            List<Usuario> usuarioList = userRepository.findAll();

            return usuarioList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(UsuarioConverter.buildUsuariosDTO(usuarioList));
        } catch (Exception e) {
            String loggerMessage = "Erro ao tentar recuperar os usuarios - [ " + e.getMessage() + " ]";
            logger.info(loggerMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(loggerMessage);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUsuario(@RequestBody UsuarioDTO usuarioDto) {
        try {
            if (UsuarioConverter.isDTOValid(usuarioDto)) {
                Usuario usuario = new Usuario(usuarioDto);
                userRepository.save(usuario);
                return ResponseEntity.ok("Usuario criado com sucesso!");
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            String loggerMessage = "Erro ao tentar salvar o usuario - [ " + e.getMessage() + " ]";
            logger.info(loggerMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(loggerMessage);
        }
    }

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateOneDigit(@RequestBody String body) {
        try {
            JsonObject json = JsonConverterUtils.convertToJsonObject(body);
            Optional<Usuario> usuarioFromRepo = userRepository.findByNome(JsonConverterUtils.getStringJsonValue(json, NOME_USUARIO_JSON_KEY));
            if (usuarioFromRepo.isPresent()) {
                Usuario usuario = usuarioFromRepo.get();
                Resultado resultado = ResultadoConverter.buildResultado(json, usuario);
                resultado.calcularDigitoUnico();
                resultado = resultadoRepository.save(resultado);
                return ResponseEntity.ok(resultado);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            String loggerMessage = "Erro ao tentar calcular o digito unico - [ " + e.getMessage() + " ]";
            logger.error(loggerMessage);
            return ResponseEntity.badRequest().body(loggerMessage);
        }

    }

}
