package mbean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Livro;
import servico.LivroServico;
import util.MensagensJSF;

@SessionScoped
@ManagedBean
public class LivroMB implements Serializable {

	private Livro livro = new Livro();
	private Livro livroEdicao = new Livro();
	private String autor;
	private double preco;
	private String imagem;
	private String descricao;
	private LivroServico servico;
	private String titulo;
	private int idLivro;
	private String titulo2;
	private List<Livro> livros;

	public String pesquisar() {
		livros = new ArrayList<Livro>();
		servico = new LivroServico();
		livros = servico.pesquisar(titulo);

		return "pesquisa.xhtml";

	}

	public void excluir(int id) {
		try {
			livro = new Livro();
			livro.setIdLivro(id);
			servico = new LivroServico();
			servico.excluir(livro);
			pesquisar();
			FacesContext.getCurrentInstance().getExternalContext().redirect("pesquisa.xhtml");
			MensagensJSF.adicionarMensagemSucesso("Livro Excluido com Sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			MensagensJSF.adicionarMensagemErro("Codigo do erro: " + e.getSQLState() + " \n" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		resetar();
	}

	public void inserir() {
		livro = new Livro();
		livro.setDescricao(getDescricao());
		livro.setAutor(getAutor());
		livro.setImagem(getImagem());
		livro.setPreco(getPreco());
		livro.setTitulo(getTitulo());
		servico = new LivroServico();
		
		try {
		servico.inserir(livro);
		MensagensJSF.adicionarMensagemSucesso("Livro Inserido com Sucesso!");
		}catch (Exception e) {
			MensagensJSF.adicionarMensagemErro("Erro ao inserir livro");
		}
		resetar();
	}
	
	public void editar() {
		servico = new LivroServico();
		try {
		servico.editar(livroEdicao);
		MensagensJSF.adicionarMensagemSucesso("Livro Editado com Sucesso!");
		}catch (Exception e) {
			MensagensJSF.adicionarMensagemErro("Erro ao editar livro");
		}
		
		resetar();
	}
	
	public void abreEditar(int id ) {
		servico = new LivroServico();
		livroEdicao = servico.pesquisarPeloId(id);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("editar.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void resetar() {
		livro = null;
		idLivro = 0;
		titulo = null;
		autor = null;
		imagem = null;
		descricao = null;
		preco = 0;
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

	public List<Livro> getLivros() {
		return livros;
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

	public Livro getLivroEdicao() {
		return livroEdicao;
	}

	public void setLivroEdicao(Livro livroEdicao) {
		this.livroEdicao = livroEdicao;
	}
	
	

}
