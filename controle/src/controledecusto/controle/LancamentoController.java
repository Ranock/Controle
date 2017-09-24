package controledecusto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controledecusto.modelo.dominio.Lancamento;
import controledecusto.servico.LancamentoService;

@RestController
@RequestMapping(value="/lancamento")
public class LancamentoController {

	
		@Autowired
		LancamentoService lancamentoService;
		
	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Lancamento> cadastrarLancamento(@RequestBody Lancamento lancamento) {
	
		
		
		lancamento = lancamentoService.cadastrarLancamento(lancamento);
			
		return new ResponseEntity<>(lancamento, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Lancamento> buscarLancamento(@PathVariable Integer id) {
		Lancamento lancamento = lancamentoService.buscarLancamento(id);
		return new ResponseEntity<>(lancamento, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Lancamento> deletarLancamento(@PathVariable Integer id) {
		lancamentoService.apagarLancamento(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@RequestMapping(value="/all", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Lancamento>> buscarLancamentos(){
		List<Lancamento> lancamentoL;
		
		lancamentoL = lancamentoService.buscarTodos();
		
		return new ResponseEntity<>(lancamentoL, HttpStatus.OK);
	}
}
