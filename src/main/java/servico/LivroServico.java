package servico;

import dao.LivroDao;
import modelo.Livro;

public class LivroServico {

	
	private LivroDao dao;
	
	public int excluir(Livro livro) {
		
		dao = new LivroDao();
		return dao.excluir(livro);
		
	}

	


}
