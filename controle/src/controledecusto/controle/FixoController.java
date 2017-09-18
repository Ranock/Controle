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

import controledecusto.modelo.dominio.Fixo;
import controledecusto.servico.FixoService;

@RestController
@RequestMapping(value="/fixo")
public class FixoController {
	
	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fixo> cadastrarFixo(@RequestBody Fixo fixo) {
	
		FixoService fix = new FixoService();
		
		fixo = fix.cadastrarFixo(fixo);
			
		return new ResponseEntity<>(fixo, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fixo> buscarFixo(@PathVariable Integer id) {
		FixoService fix = new FixoService();
		Fixo fixo = fix.buscarFixo(id);
		return new ResponseEntity<>(fixo, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Fixo> deletarFixo(@PathVariable Integer id) {
		FixoService fix = new FixoService();
		fix.apagarFixo(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@RequestMapping(value="/all", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Fixo>> buscarFixos(){
		FixoService fix = new FixoService();
		List<Fixo> fixoL;
		
		fixoL = fix.buscarTodos();
		
		return new ResponseEntity<>(fixoL, HttpStatus.OK);
	}
}
