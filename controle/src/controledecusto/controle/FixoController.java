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

import controledecusto.modelo.dominio.Fixo;
import controledecusto.servico.FixoService;

@RestController
@RequestMapping(value="/fixo")
public class FixoController {
	
	@Autowired
	FixoService fixoService;
	
	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fixo> cadastrarFixo(@RequestBody Fixo fixo) {
	
		fixo = fixoService.cadastrarFixo(fixo);
			
		return new ResponseEntity<>(fixo, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fixo> buscarFixo(@PathVariable Integer id) {
	
		Fixo fixo = fixoService.buscarFixo(id);
		return new ResponseEntity<>(fixo, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Fixo> deletarFixo(@PathVariable Integer id) {
		fixoService.apagarFixo(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
