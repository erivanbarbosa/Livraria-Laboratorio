package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Livro;
import util.FabricaConexao;
import util.FabricaConexaoHibernate;
import util.MensagensJSF;

public class LivroDao {

	/*public ArrayList<Livro> pesquisar(String titulo) {

		String pesquisaPorNome = "SELECT TITULO, ID, AUTOR, PRECO, IMAGEM, DESCRICAO FROM LIVRO ";
		Livro livro = null;

		ArrayList<Livro> lista = new ArrayList<Livro>();

		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement consulta = conexao.prepareStatement(pesquisaPorNome);
			
			//consulta.setString(1,"%" + titulo + "%");
			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {
				livro = new Livro();
				livro.setIdLivro(resultado.getInt("ID"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				lista.add(livro);
			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}*/

	public void excluir(Livro livro) {
		 EntityManager delete = FabricaConexaoHibernate.getEntityManager();
		 delete.getTransaction().begin();
		 livro = delete.find(Livro.class, livro.getIdLivro());		 
		 delete.remove(livro);
		 delete.getTransaction().commit();
		 delete.close();

	}

	public void inserir(Livro livro) {
			EntityManager entitymanager = FabricaConexaoHibernate.getEntityManager();
			entitymanager.getTransaction().begin();
			entitymanager.persist(livro);
			
			
			entitymanager.getTransaction().commit();
			entitymanager.close();
	}
	
	public List<Livro> pesquisar(String titulo)    {
		
		EntityManager entitymanager = FabricaConexaoHibernate.getEntityManager();
		
        Query query = entitymanager.createQuery("SELECT livro FROM Livro livro where livro.titulo like :nome");
        query.setParameter("nome", "%" + titulo + "%");
        List<Livro> livros = query.getResultList();
        return livros;
    }

}
