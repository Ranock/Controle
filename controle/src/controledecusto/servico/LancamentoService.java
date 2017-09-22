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
	public List<Lancamento> buscarLancamentosPorData(Integer id, Integer ano, Integer mes){
		Calendar calendarInicio = Calendar.getInstance();
		Calendar calendarFim = Calendar.getInstance();
		LancamentoDAO ldao = new LancamentoDAO();
		List<Lancamento> lancList;
		
		
		calendarInicio.clear();
		calendarInicio.set(calendarInicio.YEAR, ano);
		calendarInicio.set(calendarInicio.MONTH, mes -1);
		Date dateInicio = calendarInicio.getTime();
		
		calendarFim = calendarInicio;
		calendarFim.set(calendarFim.MONTH, mes);
		calendarFim.set(calendarFim.DAY_OF_MONTH,-1);		
		Date dateFim = calendarFim.getTime();
		
		System.out.println(dateFim);
		System.out.println(dateInicio);
		
		
		lancList = ldao.buscarLancamentosPorData(id, dateInicio, dateFim);
		
		return lancList;
		
		
	}
	public List<Lancamento> buscarLancamentosPorData(Integer id, Integer ano){
		Calendar calendarInicio = Calendar.getInstance();
		Calendar calendarFim = Calendar.getInstance();
		LancamentoDAO ldao = new LancamentoDAO();
		List<Lancamento> lancList;
		
		
		calendarInicio.clear();
		calendarInicio.set(calendarInicio.YEAR, ano);
		Date dateInicio = calendarInicio.getTime();
		
		calendarFim = calendarInicio;
		calendarInicio.set(calendarInicio.YEAR, ano + 1);
		calendarInicio.set(calendarInicio.DAY_OF_MONTH, -1);
			
		Date dateFim = calendarFim.getTime();
		
		System.out.println(dateFim);
		System.out.println(dateInicio);
		
		
		lancList = ldao.buscarLancamentosPorData(id, dateInicio, dateFim);
		
		return lancList;
		
		
	}

}
