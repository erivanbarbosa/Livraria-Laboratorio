package mbean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.FabricaConexao;

public class UsuarioMB {

	int id;
	String username;
	String nomeUsuario;
	String email;
	String senha;
	String tipoUsuario;

	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private String getUsername() {
		return username;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private String getNomeUsuario() {
		return nomeUsuario;
	}

	private void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	private String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private String getSenha() {
		return senha;
	}

	private void setSenha(String senha) {
		this.senha = senha;
	}

	private String getTipoUsuario() {
		return tipoUsuario;
	}

	private void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public boolean logar(String userName, String senha) {

		try {
			
			boolean autenticado = false;
			String sql;
			sql = "SELECT username, senha FROM usuario WHERE username = ? AND senha = ?";
			PreparedStatement ps;

			ps = FabricaConexao.getConexao().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, senha);

			ResultSet rs;
			rs = ps.executeQuery();

			if (rs.next()) {
				String usernameBanco = rs.getString("username");
				String senhaBanco = rs.getString("senha");
				boolean autentificado = true;
			

			ps.close();
			}

			return autenticado;
			
			

		} catch (SQLException ex) {
			System.out.println("Erro ao recuperar cliente/ senha.");
			throw new RuntimeException();
		}

	}
}
