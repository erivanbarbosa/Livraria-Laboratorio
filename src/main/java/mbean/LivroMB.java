package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Livro;
import servico.LivroServico;

@SessionScoped
@ManagedBean
public class LivroMB {

	private Livro livro;
	private int idLivro;
	private LivroServico servico;
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String pesquisar() {

		System.out.println("pesquisar");
		livro = new Livro();
		livro.setTitulo(titulo);
		servico = new LivroServico();
		servico.perquisar(livro);
		resetar();

		return "pesquisa.xhtml";

	}

	public String excluir() {

		livro = new Livro();
		livro.setIdLivro(idLivro);
		servico = new LivroServico();
		servico.excluir(livro);
		resetar();

		return "exemplo.xhtml";
	}
	
	private void resetar() {
		livro = null;
		idLivro = 0;
		titulo = null;
	}

}
