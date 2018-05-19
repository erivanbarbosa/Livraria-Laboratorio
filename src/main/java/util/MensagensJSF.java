package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagensJSF {
	public static void adicionarMensagemSucesso(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}

	public static void adicionarMensagemErro(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO:", mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
}