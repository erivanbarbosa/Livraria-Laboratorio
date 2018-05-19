package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;
import modelo.enuns.TipoUsuario;
import util.FabricaConexao;

public class UsuarioDao {
	
	public Usuario autenticar(Usuario autenticar_usuario){
		String autenticaUsuario = "SELECT * FROM USUARIO WHERE username = ? AND senha = ?";
		Usuario usuario = null;
		
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement consulta = conexao.prepareStatement(autenticaUsuario);
			
			consulta.setString(1, autenticar_usuario.getUserName());
			consulta.setString(2, autenticar_usuario.getSenha());
			
			ResultSet resultado = consulta.executeQuery();
			
			
			while(resultado.next()) {
				usuario = new Usuario();
				usuario.setId(resultado.getInt("ID"));
				usuario.setUserName(resultado.getString("USERNAME"));
				usuario.setSenha(resultado.getString("NOMEUSUARIO"));
				usuario.setEmail(resultado.getString("EMAIL"));
				usuario.setSenha(resultado.getString("SENHA"));
				usuario.setTipoUsuario(TipoUsuario.valueOf(autenticar_usuario.getUserName()));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return usuario;

	}
}