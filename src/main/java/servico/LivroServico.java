package servico;

import java.util.ArrayList;

import dao.LivroDao;
import modelo.Livro;

public class LivroServico {

	private LivroDao dao;

	public int inserir(Livro livro) {

		dao = new LivroDao();
		return dao.inserir(livro);

	}
	
	public int excluir(Livro livro) {

		dao = new LivroDao();
		return dao.excluir(livro);

	}

	public ArrayList<Livro> perquisar(Livro livro) {
		dao = new LivroDao();
		return dao.pesquisar(livro.getTitulo());
	}

}
