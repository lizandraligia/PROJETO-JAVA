package br.ufrpe.LsCine.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class Visual {

	BorderPane paneLogin;
	BorderPane border;
	FXMLLoader login, menu;
	BorderPane paneMenu;
	
	public static Visual instancia;
	
	public static synchronized Visual getInstance(){
		if(instancia == null){
			instancia = new Visual();
		}
		return instancia;
	}
	
	private Visual(){
		try {
			login = new FXMLLoader(this.getClass().getResource("Login.fxml"));
			this.paneLogin = login.load();
			menu = new FXMLLoader(this.getClass().getResource("Menu.fxml"));
			this.paneMenu = menu.load();
			this.border = Main.getRoot();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void getLogin(){
		
		border.setCenter(this.paneLogin);
		LoginController controlador = this.login.getController();
		controlador.tfLogin.clear();
		controlador.tfSenha.clear();
		
	}
	
	public void getMenu(){
		
		border.setCenter(this.paneMenu);
		MenuController controlador = this.menu.getController();
		controlador.financeiro();
		controlador.sair();
	}
	
	
}
