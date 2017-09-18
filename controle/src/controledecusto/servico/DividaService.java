package controledecusto.servico;

import java.util.List;

import controledecusto.modelo.dao.DividaDAO;
import controledecusto.modelo.dominio.Divida;

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

	public List<Divida> buscarTodos() {

		return null;
	}

}
