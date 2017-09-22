package controledecusto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(Teste.class, args);
	}

}
//
//public class Teste {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//			Usuario user = new Usuario();
//			Fixos fix = new Fixos();
//			Lancamento lanc = new Lancamento();
//			Lancamento lanc2 = new Lancamento();
//			Divida div = new Divida();
//			
//
//			UsuarioDAO udao = new UsuarioDAO();
//			LancamentoDAO ldao = new LancamentoDAO();
//			DividaDAO ddao = new DividaDAO();
//			
//			FixoDAO fdao = new FixoDAO();
//			
//			user.setNome("Hugo");
//			user.setSaldo(0);
//			user = udao.inserir(user);
//			
//			fix.setNomeFixo("fixo1");
//			fix.setPrecoVaria(false);
//			fix.setTipoFixo(1);
//			fix.setValorFixo(10);
//			
//			lanc.setDataLancamento("10-10-1000");
//			lanc.setNomeLancamento("teste1");
//			lanc.setValorLancamento(20);
//			
//			div.setData("10-10-2000");
//			div.setNomeDivida("teste1");
//			div.setQuitacao(false);
//			div.setValorDivida(10f);
//			
//			lanc2.setDataLancamento("10-10-2000");
//			lanc2.setNomeLancamento("teste2");
//			lanc2.setValorLancamento(10);
//
//			div.setUsuario(user);
//			div = ddao.inserir(div);
//			lanc.setUsuario(user);
//			lanc2.setUsuario(user);
//			lanc.setDivida(div);
//			lanc2= ldao.inserir(lanc2);
//			lanc = ldao.inserir(lanc);
//			fix.setUsuario(user);
//			fix = fdao.inserir(fix);
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//		
//	}
//
//}
