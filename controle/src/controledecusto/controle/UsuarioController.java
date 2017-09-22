package controledecusto.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import controledecusto.modelo.dominio.Divida;
import controledecusto.modelo.dominio.Fixo;
import controledecusto.modelo.dominio.Lancamento;
import controledecusto.modelo.dominio.Usuario;
import controledecusto.servico.DividaService;
import controledecusto.servico.FixoService;
import controledecusto.servico.LancamentoService;
import controledecusto.servico.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {

		UsuarioService usu = new UsuarioService();
		usuario = usu.cadastrarUsuario(usuario);

		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id) {
		UsuarioService usu = new UsuarioService();
		Usuario usuario = usu.buscarUsuario(id);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> deletarUsuario(@PathVariable Integer id) {
		UsuarioService usu = new UsuarioService();
		usu.apagarUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> buscarUsuarios() {
		UsuarioService usu = new UsuarioService();
		List<Usuario> usuarioL;

		usuarioL = usu.buscarTodos();

		return new ResponseEntity<>(usuarioL, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/dividas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Divida>> buscarDividas(@PathVariable Integer id) {
		DividaService div = new DividaService();
		List<Divida> dividaL;

		dividaL = div.buscarDividaUsuario(id);
		//
		return new ResponseEntity<>(dividaL, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/lancamentos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Lancamento>> buscarLancamentos(	@PathVariable Integer id, 
																@RequestParam("ano") Integer ano, 
																@RequestParam(value="mes", required= false) Integer mes, 
																@RequestParam( value="dia", required =false) Integer dia,
																@RequestParam( value="anofim", required =false) Integer anofim,
																@RequestParam( value="mesfim", required =false) Integer mesfim,
																@RequestParam( value="diafim", required =false) Integer diafim) {
		LancamentoService lanc = new LancamentoService();
		List<Lancamento> lancamentoL = new ArrayList<>();
		
		if(ano!= null){
						
				lancamentoL = lanc.buscarLancamentosPorData(id, ano, mes, dia, anofim, mesfim, diafim);

		
		}else{
			
			lancamentoL = lanc.buscarLancamentosUsuario(id);
		}
		
		return new ResponseEntity<>(lancamentoL, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/fixos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fixo>> buscarFixo(@PathVariable Integer id) {
		FixoService fix = new FixoService();
		List<Fixo> fixoL;

		fixoL = fix.buscarFixosUsuario(id);
		//
		return new ResponseEntity<>(fixoL, HttpStatus.OK);
	}
}
