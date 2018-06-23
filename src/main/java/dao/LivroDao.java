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
		
        Query query = entitymanager.createQuery("SELECT livro FROM Livro livro where upper(livro.titulo) like upper(:nome)");
        query.setParameter("nome",  "%"+ titulo + "%");
        List<Livro> livros = query.getResultList();
        return livros;
        /*like lower(concat('%', ?1,'%'))*/
    }

	/*
	 * public int inserir(Livro livro) { String sql =
	 * "INSERT  INTO livro (titulo,autor,preco,imagem,descricao) VALUES (?,?,?,?,?)"
	 * ; int result = 0; try { Connection conn = FabricaConexao.getConexao();
	 * PreparedStatement consulta = conn.prepareStatement(sql);
	 * consulta.setString(1, livro.getTitulo()); consulta.setString(2,
	 * livro.getAutor()); consulta.setDouble(3, livro.getPreco());
	 * consulta.setString(4, livro.getImagem()); consulta.setString(5,
	 * livro.getDescricao()); result = consulta.executeUpdate();
	 * System.out.println("Dados inseridos!");
	 * 
	 * } catch (SQLException e) { System.out.println(e); }
	 * 
	 * return result; }
	 */

}
