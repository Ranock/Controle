package controledecusto.servico;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import controledecusto.modelo.dao.LancamentoDAO;
import controledecusto.modelo.dominio.Lancamento;

//TODO Colocar validação para verificar se os campos ano e mes são numeros
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

	public List<Lancamento> buscarLancamentosPorData(Integer id, Integer ano, Integer mes, Integer dia, Integer anofim,
			Integer mesfim, Integer diafim) {

		Calendar calendarInicio = Calendar.getInstance();
		Calendar calendarFim = Calendar.getInstance();
		LancamentoDAO ldao = new LancamentoDAO();
		List<Lancamento> lancList;

		if (mes == null)
			mes = 0;

		if (dia == null)
			dia = 1;

		calendarInicio.clear();
		calendarInicio.set(calendarInicio.YEAR, ano);
		calendarInicio.set(calendarInicio.MONTH, mes - 1);
		calendarInicio.set(calendarInicio.DAY_OF_MONTH, dia);
		Date dateInicio = calendarInicio.getTime();

		if ((anofim == null)) {

			calendarFim = calendarInicio;
			calendarFim.set(calendarFim.MONTH, mes);
			calendarFim.set(calendarFim.DAY_OF_MONTH, -1);
			Date dateFim = calendarFim.getTime();

			lancList = ldao.buscarLancamentosPorData(id, dateInicio, dateFim);

			return lancList;
		} else {

			if (mesfim == null)
				calendarFim.set(calendarFim.MONTH, mes);
			else
				calendarFim.set(calendarFim.MONTH, mesfim -1);
			if (diafim == null)
				calendarFim.set(calendarFim.DAY_OF_MONTH, -1);
			else
				calendarFim.set(calendarFim.DAY_OF_MONTH, diafim);

			Date dateFim = calendarFim.getTime();

			lancList = ldao.buscarLancamentosPorData(id, dateInicio, dateFim);

			return lancList;
		}

	}

}
