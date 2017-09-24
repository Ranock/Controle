package controledecusto.servico;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import controledecusto.modelo.dao.LancamentoDAO;
import controledecusto.modelo.dominio.Lancamento;
import util.DataConverterUtil;

//TODO Colocar validação para verificar se os campos ano e mes são numeros

@Service
public class LancamentoService {

	public Lancamento cadastrarLancamento(Lancamento lancamento) {
		LancamentoDAO ldao = new LancamentoDAO();

		Date d = lancamento.getDataLancamento();
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

	public List<Lancamento> buscarLancamentosUsuario(Integer id) {
		LancamentoDAO ldao = new LancamentoDAO();
		List<Lancamento> lancL;
		lancL = ldao.buscarLancamentosUsuario(id);

		return lancL;
	}

	public List<Lancamento> buscarLancamentosPorData(String dataIni, String dataFin, Integer idUsuario){
		
		List<Lancamento> lancL;
		LancamentoDAO ldao = new LancamentoDAO();
		
		Date dataInicio;
		Date dataFim;
		dataInicio = DataConverterUtil.converterString(dataIni);
		dataFim = DataConverterUtil.converterString(dataFin);
		
		
		if((dataInicio == null) || (dataFim ==null)) {
			return null;
		}else {
			lancL = ldao.buscarLancamentosPorData(idUsuario, dataInicio, dataFim);
			return lancL;
		}
		
	
	}

}
