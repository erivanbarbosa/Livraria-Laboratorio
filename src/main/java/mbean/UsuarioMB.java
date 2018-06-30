package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Usuario;
import modelo.enuns.TipoUsuario;
import servico.UsuarioServico;
import util.MensagensJSF;

@ManagedBean
@SessionScoped

public class UsuarioMB {
	private int cod;
	private String userName;
	private String nomeUsuario;
	private String email;
	private String senha;
	private TipoUsuario tipousuario;
	private UsuarioServico servico;
	private boolean logado;

	public void autenticar() {

		String validacao = null;
		Usuario usuario = new Usuario();
		usuario.setUserName(this.userName);
		usuario.setSenha(this.senha);
		servico = new UsuarioServico();

		try {
			if (servico.autenticar(usuario) != null) {
				validacao = "pesquisa.xhtml";
				logado = true;
				FacesContext.getCurrentInstance().getExternalContext().redirect(validacao);
			} else {
				MensagensJSF.adicionarMensagemErro("Usuário ou Senha Incorretos");
				logado = false;
			}
			resetar();
		} catch (Exception e) {
			MensagensJSF.adicionarMensagemErro("Usuário ou Senha Incorretos");
			logado = false;
		}
		// FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("cadastrarItem");

	}

	public String sair() {
		resetar();
		logado = false;

		return "index.xhtml";
	}

	public void resetar() {
		this.cod = 0;
		this.email = null;
		this.nomeUsuario = null;
		this.senha = null;
		this.tipousuario = null;
		this.userName = null;

	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	public boolean isLogado() {
		return this.logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
}
