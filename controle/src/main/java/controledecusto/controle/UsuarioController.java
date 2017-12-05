package controledecusto.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	LancamentoService lancamentoService;

	@Autowired
	DividaService dividaService;

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {

		usuario = usuarioService.cadastrarUsuario(usuario);

		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id) {
		Usuario usuario = usuarioService.buscarUsuario(id);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> deletarUsuario(@PathVariable Integer id) {
		usuarioService.apagarUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> buscarUsuarios() {
		UsuarioService usuarioService = new UsuarioService();
		List<Usuario> usuarioL;

		usuarioL = usuarioService.buscarTodos();

		return new ResponseEntity<>(usuarioL, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/dividas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Divida>> buscarDividas(@PathVariable Integer id) {

		List<Divida> dividaL;

		dividaL = dividaService.buscarDividaUsuario(id);
		//
		return new ResponseEntity<>(dividaL, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/lancamentos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Lancamento>> buscarLancamentos(@PathVariable Integer id,
				@RequestParam(value = "datainicial", required = false) String dataInicial,
				@RequestParam(value = "datafinal", required = false) String dataFinal) {

		List<Lancamento> lancamentoL = new ArrayList<>();

		if ((dataInicial == null) || (dataFinal == null))
			lancamentoL = lancamentoService.buscarLancamentosUsuario(id);
		else
			lancamentoL = lancamentoService.buscarLancamentosPorData(dataInicial, dataFinal, id);

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
