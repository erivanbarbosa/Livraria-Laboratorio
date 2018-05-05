package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Livro;
import servico.LivroServico;

@SessionScoped
@ManagedBean
public class LivroMB {

	private Livro livro;
	private String autor;
	private double preco;
	private String imagem;
	private String descricao;
	private LivroServico servico;
	private String titulo;
	private int idLivro;

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
	
	public String adicionar() {
		livro = new Livro();
		livro.setDescricao(getDescricao());
		livro.setAutor(getAutor());
		livro.setImagem(getImagem());
		livro.setPreco(getPreco());
		livro.setTitulo(getTitulo());
		servico = new LivroServico();
		servico.inserir(livro);
		resetar();
		return "cadastrado.xhtml";
	}

	private void resetar() {
		livro = null;
		idLivro = 0;
		titulo = null;
		autor=null;
		imagem=null;
		descricao=null;
		preco=0;
	}

}
