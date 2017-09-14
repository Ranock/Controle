package controledecusto.controle;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controledecusto.modelo.dominio.Usuario;

@RestController
public class UsuarioController {

	@RequestMapping(value="/cadastrarusuario", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void cadastrarUsuario(@RequestBody Usuario usuario) {

	}
}
