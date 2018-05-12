 package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Usuario;
import modelo.enuns.TipoUsuario;
import servico.UsuarioServico;
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
	
	
	public String autenticar() {
		String validacao=null;
		Usuario usuario = new Usuario();
		usuario.setUsename(this.userName);
		usuario.setSenha(this.senha);
		servico = new UsuarioServico();
		
		if(servico.autenticar(usuario)!= null) {
			validacao="cadastrarlivro.xhtml";
		}else {
			validacao="erroautenticar.xhtml";
		}
		resetar();
		return validacao;
	}
	
public String cadastrar () {
	Usuario usuario = new Usuario();
	usuario.setEmail(this.getEmail());
	usuario.setId(this.getCod());
	usuario.setNomeUsuario(this.getNomeUsuario());
	usuario.setSenha(this.getSenha());
	usuario.setTipoUsuario(this.getTipousuario());
	usuario.setUsename(this.getUserName());
	servico = new UsuarioServico();
	servico.cadastrar(usuario);
	resetar();
		return "cadastrado.xhtml";
		
}
public String excluir () {
	Usuario usuario = new Usuario();
	usuario.setEmail(this.getEmail());
	usuario.setId(this.getCod());
	usuario.setNomeUsuario(this.getNomeUsuario());
	usuario.setSenha(this.getSenha());
	usuario.setTipoUsuario(this.getTipousuario());
	usuario.setUsename(this.getUserName());
	servico = new UsuarioServico();
	servico.excluir (usuario);
	resetar();
	return "excluido.xhtml";
	
	
}
public String pesquisar () {
Usuario usuario = new Usuario();
usuario.setUsename(this.getUserName());	
servico = new UsuarioServico();
servico.pesquisar (usuario);
resetar();
return "pesquisa.xhtml";

}
public void resetar() {
	this.cod=0;
	this.email=null;
	this.nomeUsuario=null;
	this.senha=null;
	this.tipousuario=null;
	this.userName=null;
	
	
}

}
