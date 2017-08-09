package br.ufrpe.LsCine.gui;

//import java.awt.Label;
//import java.awt.TextField;

import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Conta;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField; 
import javafx.scene.control.Label;

public class LoginController {

	@FXML TextField tfLogin;
	@FXML PasswordField tfSenha;
	@FXML Label lblError;
	private Fachada fachada = Fachada.getInstancia();
	
	public void Login(){
		String login = this.tfLogin.getText();
		String senha = this.tfSenha.getText();
		try{
			this.fachada.logar(new Conta(login,senha));
			Visual.getInstance().getMenu();
			System.out.println("funfou");

		}
		catch(Exception e){
			this.lblError.setText(e.getMessage());
		}
	}

}
