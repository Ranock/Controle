package controledecusto.servico;

import java.util.List;

import controledecusto.modelo.dao.FixoDAO;
import controledecusto.modelo.dao.LancamentoDAO;
import controledecusto.modelo.dominio.Divida;
import controledecusto.modelo.dominio.Fixo;
import controledecusto.modelo.dominio.Lancamento;

public class FixoService {

	public Fixo cadastrarFixo(Fixo fixo) {
		FixoDAO fdao = new FixoDAO();
		fixo = fdao.inserir(fixo);
		return fixo;
	}

	public Fixo buscarFixo(Integer id) {
		FixoDAO fdao = new FixoDAO();
		Fixo fixo;
		fixo = fdao.lerPorId(id);

		return fixo;
	}

	public void apagarFixo(Integer id) {
		FixoDAO fdao = new FixoDAO();
		Fixo fixo;
		fixo = fdao.lerPorId(id);
		fdao.Excluir(fixo);
	}
	public List<Fixo> buscarFixosUsuario(Integer id) {
		FixoDAO fdao = new FixoDAO();
		List<Fixo> fixL;
		fixL = fdao.buscarFixosUsuario(id);
		
		return fixL;
	}

}
