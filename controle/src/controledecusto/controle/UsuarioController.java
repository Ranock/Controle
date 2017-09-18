package controledecusto.controle;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controledecusto.modelo.dominio.Usuario;
import controledecusto.servico.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	



	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
	
		UsuarioService usu = new UsuarioService();
		usuario = usu.cadastrarUsuario(usuario);
		
		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id) {
		UsuarioService usu = new UsuarioService();
		Usuario usuario = usu.buscarUsuario(id);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Usuario> deletarUsuario(@PathVariable Integer id) {
		UsuarioService usu = new UsuarioService();
		usu.apagarUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@RequestMapping(value="/all", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Usuario>> buscarUsuarios(){
		UsuarioService usu = new UsuarioService();
		List<Usuario> usuarioL;
		
		usuarioL = usu.buscarTodos();
		
		return new ResponseEntity<>(usuarioL, HttpStatus.OK);
	}
}
