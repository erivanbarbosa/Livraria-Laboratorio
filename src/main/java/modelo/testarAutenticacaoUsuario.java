package modelo;

import dao.UsuarioDao;

public class testarAutenticacaoUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = new Usuario();
		usuario.setUsername("admimistrador");
		usuario.setSenha("123456");
		Usuario usuarioSelecionado = usuarioDao.autenticar(usuario);
		if (usuario != null) {
			System.out.println(usuarioSelecionado.getEmail());
		}

	}

}