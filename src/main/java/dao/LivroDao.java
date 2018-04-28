package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Livro;
import util.FabricaConexao;

public class LivroDao {
	
	public ArrayList<Livro> pesquisar(String titulo){
		
		String pesquisaPorNome = "SELECT TITULO, COD_LIVRO, AUTOR, PRECO, IMAGEM, DESCRICAO FROM LIVRO WHERE TITULO LIKE ?";
		Livro livro = null;
		
		ArrayList<Livro> lista = new ArrayList<Livro>();
		
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement consulta = conexao.prepareStatement(pesquisaPorNome);
			
			consulta.setString(1, "%" + titulo.toUpperCase()+"%");
			ResultSet resultado = consulta.executeQuery();
			
			while (resultado.next()) {
				livro = new Livro();
				livro.setIdLivro(resultado.getInt("COD_LIVRO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				lista.add(livro);			
			}
		resultado.close();	
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return lista;		
	}
	
	
	

}
