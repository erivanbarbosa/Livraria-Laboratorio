package servico;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.LivroDao;
import modelo.Livro;

public class LivroServico {

	private LivroDao dao;

	public int inserir(Livro livro) {

		dao = new LivroDao();
		return dao.inserir(livro);

	}
	
	public void excluir(Livro livro) throws SQLException {

		dao = new LivroDao();
		dao.excluir(livro);

	}

	public ArrayList<Livro> perquisar(Livro livro) {
		dao = new LivroDao();
		return dao.pesquisar(livro.getTitulo());
		
		
	}

}
