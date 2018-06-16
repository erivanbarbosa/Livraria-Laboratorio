package mbean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import modelo.Livro;
import servico.LivroServico;
import util.MensagensJSF;

@ViewScoped
@ManagedBean
public class LivroMB implements Serializable {

	private Livro livro = new Livro();
	private String autor;
	private double preco;
	private String imagem;
	private String descricao;
	private LivroServico servico;
	private String titulo;
	private int idLivro;
	private String titulo2;
	private List <Livro> lista ;
	public List getLista() {
		return lista;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public String getTitulo2() {
		return titulo2;
	}

	public void setTitulo2(String titulo2) {
		this.titulo2 = titulo2;
	}

	private List<Livro> livros;
	
	
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

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
	livros = new ArrayList<Livro>();
	livro = new Livro();
	livro.setTitulo(titulo);
	servico = new LivroServico();
	livros = servico.perquisar(livro);

	

/*	for(Livro lista : livros ) {
	this.setTitulo2(lista.getTitulo());
	this.setAutor(lista.getAutor());
	this.setPreco(lista.getPreco());
	this.setDescricao(lista.getDescricao());
	this.setIdLivro(lista.getIdLivro());
	}*/
	
	return "pesquisa.xhtml";

	}

	public void excluir() {
		try {
			//livro = new Livro();
			//livro.setIdLivro(idLivro);
			servico = new LivroServico();
			servico.excluir(livro);
			MensagensJSF.adicionarMensagemSucesso("Livro Excluido com Sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			MensagensJSF.adicionarMensagemErro("Codigo do erro: " + e.getSQLState() + " \n" + e.getMessage());
		}
		resetar();		
	}
	
	public String inserir() {
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
