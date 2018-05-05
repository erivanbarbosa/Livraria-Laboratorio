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
	private String autor;
	private double preco;
	private String imagem;
	private String descricao;
	
	
	

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LivroServico getServico() {
		return servico;
	}

	public void setServico(LivroServico servico) {
		this.servico = servico;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

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
