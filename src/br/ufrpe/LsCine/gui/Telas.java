package br.ufrpe.LsCine.gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class Telas {

	BorderPane paneLogin;
	BorderPane border;
	FXMLLoader login, menu, adicionarFilme, financeiro;
	BorderPane paneMenu;
	BorderPane paneAdicionarFilme; 
	BorderPane paneFinanceiro;
	
	public static Telas instancia;
	
	public static synchronized Telas getInstance(){
		if(instancia == null){
			instancia = new Telas();
		}
		return instancia;
	}
	
	private Telas(){
		try {
			login = new FXMLLoader(this.getClass().getResource("Login.fxml"));
			this.paneLogin = login.load();
			menu = new FXMLLoader(this.getClass().getResource("Menu.fxml"));
			this.paneMenu = menu.load();
			adicionarFilme = new FXMLLoader(this.getClass().getResource("AdicionarFilme.fxml"));
			this.paneAdicionarFilme = adicionarFilme.load();
			financeiro = new FXMLLoader(this.getClass().getResource("Financeiro.fxml"));
			this.paneFinanceiro = financeiro.load();
			this.border = Main.getRoot();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void getLogin(){	
		border.setCenter(this.paneLogin);	
	}
	
	public void getMenu(){	
		border.setCenter(this.paneMenu);
	}
	
	public void getAdicionarFilme(){
		border.setCenter(this.paneAdicionarFilme);
	}
	
	public void getFinanceiro(){
		border.setCenter(this.paneFinanceiro);
	}
	
	
}
