package br.ufrpe.LsCine.gui;

import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Conta;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField; 
import javafx.scene.control.Label;

public class LoginController {

	@FXML TextField tfLogin;
	@FXML PasswordField tfSenha;
	
	private Fachada fachada = Fachada.getInstancia();
	
	public void Login(){
		String login = this.tfLogin.getText();
		String senha = this.tfSenha.getText();
		try{
			this.fachada.logar(login, senha);
			Telas.getInstance().getMenu();

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
