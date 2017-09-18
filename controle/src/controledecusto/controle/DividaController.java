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

import controledecusto.modelo.dominio.Divida;
import controledecusto.servico.DividaService;

@RestController
@RequestMapping(value="/divida")
public class DividaController {
	
	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Divida> cadastrarDivida(@RequestBody Divida divida) {
	
		DividaService div = new DividaService();
		
		divida = div.cadastrarDivida(divida);
			
		return new ResponseEntity<>(divida, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Divida> buscarDivida(@PathVariable Integer id) {
		DividaService div = new DividaService();
		Divida divida = div.buscarDivida(id);
		return new ResponseEntity<>(divida, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Divida> deletarDivida(@PathVariable Integer id) {
		DividaService div = new DividaService();
		div.apagarDivida(id);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	@RequestMapping(value="/all", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Divida>> buscarDividas(){
		DividaService div = new DividaService();
		List<Divida> dividaL;
		
		dividaL = div.buscarTodos();
		
		return new ResponseEntity<>(dividaL, HttpStatus.OK);
	}
}
