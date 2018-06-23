package servico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.LivroDao;
import modelo.Livro;

public class LivroServico {

	private LivroDao dao;

	public void inserir(Livro livro) {

		dao = new LivroDao();
		dao.inserir(livro);

	}
	
	public void excluir(Livro livro) throws SQLException {

		dao = new LivroDao();
		dao.excluir(livro);

	}

	public List<Livro> pesquisar(String titulo) {
		dao = new LivroDao();
		return dao.pesquisar(titulo);
		
		
	}

}
