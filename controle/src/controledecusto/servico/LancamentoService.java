package controledecusto.servico;

import java.util.List;

import controledecusto.modelo.dao.LancamentoDAO;
import controledecusto.modelo.dominio.Lancamento;

public class LancamentoService {

	public Lancamento cadastrarLancamento(Lancamento lancamento) {
		LancamentoDAO ldao = new LancamentoDAO();
		lancamento = ldao.inserir(lancamento);
		return lancamento;
	}

	public Lancamento buscarLancamento(Integer id) {
		LancamentoDAO ldao = new LancamentoDAO();
		Lancamento lancamento;
		lancamento = ldao.lerPorId(id);

		return lancamento;
	}

	public void apagarLancamento(Integer id) {
		LancamentoDAO ldao = new LancamentoDAO();
		Lancamento lancamento;
		lancamento = ldao.lerPorId(id);
		ldao.Excluir(lancamento);
	}
	public List<Lancamento> buscarTodos() {

		return null;
	}

}
