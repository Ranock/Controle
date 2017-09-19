package controledecusto.servico;

import java.util.List;

import controledecusto.modelo.dao.DividaDAO;
import controledecusto.modelo.dao.UsuarioDAO;
import controledecusto.modelo.dominio.Divida;
import controledecusto.modelo.dominio.Usuario;

public class DividaService {

	public Divida cadastrarDivida(Divida divida) {
		DividaDAO ddao = new DividaDAO();
		divida = ddao.inserir(divida);
		return divida;
	}

	public Divida buscarDivida(Integer id) {
		DividaDAO ddao = new DividaDAO();
		Divida divida;
		divida = ddao.lerPorId(id);

		return divida;
	}

	public void apagarDivida(Integer id) {
		DividaDAO ddao = new DividaDAO();
		Divida divida;
		divida = ddao.lerPorId(id);
		ddao.Excluir(divida);
	}

	public List<Divida> buscarDividaUsuario(Integer id) {
		DividaDAO ddao = new DividaDAO();
		List<Divida> div;
		div = ddao.buscarDividasUsuario(id);
		
		
		return div;
	}

}
