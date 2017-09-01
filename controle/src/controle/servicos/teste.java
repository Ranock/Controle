package controle.servicos;

import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		
		u.setIdUsuario(1);
		u.setNome("teste");
		u.setSaldo(0);
		
//		Lancamento lanc = new Lancamento();
//		
//		lanc.setIdLacamento(1);
//		lanc.setNomeLancamento("teste");
//		lanc.setValorLancamento(10.0f);
//		lanc.setDataLancamento("01-01-2001");
//		lanc.setUsuario(u);
//		
//		Lancamento lanc2 = new Lancamento();
//		
//		lanc2.setIdLacamento(2);
//		lanc2.setNomeLancamento("teste");
//		lanc2.setValorLancamento(10.0f);
//		lanc2.setDataLancamento("01-01-2001");
//		lanc2.setUsuario(u);
//		
//		
//		List<Lancamento> lancl = new ArrayList<>();
//		lancl.add(lanc);
//		lancl.add(lanc2);
//		
//		u.setLancamento(lancl);
//		
		
//		
//		Divida div = new Divida();
//		div.setData("02-02-2202");
//		div.setNomeDivida("testeDiv");
//		div.setQuitacao(false);
//		div.setValorDivida(10f);
//		div.setUsuario(u);
//		div.setIdDivida(1);
//		
//		List<Divida> divl = new ArrayList<>();
//		divl.add(div);
//		
//		u.setDivida(divl);
		
		
		
		UsuarioDAO udao = new UsuarioDAO();
		udao.inserir(u);
		
	}

}
