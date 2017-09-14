package controledecusto;

import controledecusto.modelo.dao.DividaDAO;
import controledecusto.modelo.dao.FixoDAO;
import controledecusto.modelo.dao.LancamentoDAO;
import controledecusto.modelo.dao.UsuarioDAO;
import controledecusto.modelo.dominio.Divida;
import controledecusto.modelo.dominio.Fixos;
import controledecusto.modelo.dominio.Lancamento;
import controledecusto.modelo.dominio.Usuario;

//@SpringBootApplication
//public class Teste {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		SpringApplication.run(Teste.class, args);
//	}
//
//}

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Usuario user = new Usuario();
			Fixos fix = new Fixos();
			Lancamento lanc = new Lancamento();
			Lancamento lanc2 = new Lancamento();
			Divida div = new Divida();
			

			UsuarioDAO udao = new UsuarioDAO();
			LancamentoDAO ldao = new LancamentoDAO();
			DividaDAO ddao = new DividaDAO();
			
			FixoDAO fdao = new FixoDAO();
			
			user.setNome("Hugo");
			user.setSaldo(0);
			udao.inserir(user);
			
			fix.setNomeFixo("fixo1");
			fix.setPrecoVaria(false);
			fix.setTipoFixo(1);
			fix.setValorFixo(10);
			
			lanc.setDataLancamento("10-10-1000");
			lanc.setNomeLancamento("teste1");
			lanc.setValorLancamento(20);
			
			div.setData("10-10-2000");
			div.setNomeDivida("teste1");
			div.setQuitacao(false);
			div.setValorDivida(10);
			
			lanc2.setDataLancamento("10-10-2000");
			lanc2.setNomeLancamento("teste2");
			lanc2.setValorLancamento(10);

			div.setLancamento(lanc2);
			
			user.setDivida(div);
			user.setLancamento(lanc);
			user.setLancamento(lanc2);
			user.setFixo(fix);
			
			
			
			
			udao.inserir(user);
		
	}

}
