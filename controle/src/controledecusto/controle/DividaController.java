package controledecusto.controle;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class DividaController {
	
	@RequestMapping("/teste")
	public String helloWord(){
		return "Hello World";
	}
	
}
