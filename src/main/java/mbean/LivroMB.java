package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Livro;
import servico.LivroServico;

@ViewScoped
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
	
	public String excluir() {
		//System.out.println(idLivro);
		livro = new Livro();
		livro.setIdLivro(idLivro);
		servico = new LivroServico();
		servico.excluir(livro);
		
		return "exemplo.xhtml";
	}

}
