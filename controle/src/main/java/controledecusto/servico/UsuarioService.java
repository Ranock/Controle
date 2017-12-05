package controledecusto.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import controledecusto.modelo.dao.UsuarioDAO;
import controledecusto.modelo.dominio.Usuario;

@Service
public class UsuarioService {

	public Usuario cadastrarUsuario(Usuario usuario) {
		UsuarioDAO udao = new UsuarioDAO();
		usuario = udao.inserir(usuario);
		return usuario;
	}

	public Usuario buscarUsuario(Integer id) {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario usuario;
		usuario = udao.lerPorId(id);

		return usuario;
	}

	public void apagarUsuario(Integer id) {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario usuario;
		usuario = udao.lerPorId(id);
		udao.Excluir(usuario);
	}

	public List<Usuario> buscarTodos() {
		List<Usuario> usuarioList = new ArrayList<>();
		Usuario usu = new Usuario();
		usu.setNome("Testelist");
	
		usuarioList.add(usu);
		usu = new Usuario();
		usu.setNome("Testelist2");
	
		usuarioList.add(usu);
		return usuarioList;
	}

}
