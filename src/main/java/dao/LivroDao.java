package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Livro;
import util.FabricaConexaoHibernate;

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
	
	public void editar(Livro livro) {
		EntityManager entitymanager = FabricaConexaoHibernate.getEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(livro);
		
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

	public Livro pesquisarPorId(int id) {
		EntityManager entitymanager = FabricaConexaoHibernate.getEntityManager();

		Livro livro = entitymanager.find(Livro.class, id);
		
		entitymanager.close();
		
       return livro;
	}
}
