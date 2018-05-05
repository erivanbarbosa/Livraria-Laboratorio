package servico;

import java.util.ArrayList;

import dao.LivroDao;
import modelo.Livro;

public class LivroServico {

	private LivroDao dao;

	public int inserir(Livro livro) {

		//dao = new LivroDao();
		//return dao.inserir(livro);
		
		if (livro.getTitulo() != null && livro.getDescricao() != null && livro.getPreco() != 0 && livro.getAutor() != null && livro.getImagem() != null) {
			
			dao = new LivroDao();
			
		} else {
			return 0;
		}
		return 0;

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
