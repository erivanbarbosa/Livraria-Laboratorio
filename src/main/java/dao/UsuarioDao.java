package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Usuario;
import util.FabricaConexao;

public class UsuarioDao {

	
	 public int inserir(Usuario usuario) {
			 int result=0;
			 String sql="INSERT INTO usuario(nome,username,senha) values (?,?,?)";
			 try {
				 Connection conn = FabricaConexao.getConexao();
				 PreparedStatement dados=conn.prepareStatement(sql);
				 dados.setString(1, usuario.getNome());
				 dados.setString(2, usuario.getUsername());
				 dados.setString(3, usuario.getSenha());
				 result=dados.executeUpdate();				 
				 
			 }catch(SQLException e) {
				 System.out.println(e);
			 }
			 
			 return result;
			 
	 }
}
