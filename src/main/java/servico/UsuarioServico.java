package servico;

public class UsuarioServico {

	private UsuarioDao dao;

	public Usuario autenticar(Usuario usuario) {

		dao = new UsuarioDao();

		return dao.autenticar(usuario);
	}
}
