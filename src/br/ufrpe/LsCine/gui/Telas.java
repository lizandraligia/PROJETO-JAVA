package br.ufrpe.LsCine.gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class Telas {

	BorderPane paneLogin;
	BorderPane border;
<<<<<<< HEAD
	FXMLLoader login, menu, adicionarFilme, financeiro, adicionarSala, adicionarSessao, adicionado,
				removerSala, removerSessao, comprarIngresso;
=======
	FXMLLoader login, menu, adicionarFilme, financeiro, adicionarSala, adicionarSessao, adicionado, removerSala, removerSessao,  removerFilme;
>>>>>>> 8432f6832531133fc7b43cda80ed3c8424830849
	BorderPane paneMenu;
	BorderPane paneAdicionarFilme; 
	BorderPane paneFinanceiro;
	BorderPane paneAdicionarSala;
	BorderPane paneAdicionarSessao;
	BorderPane paneRemoverSala;
	BorderPane paneRemoverSessao;
<<<<<<< HEAD
	BorderPane paneComprarIngresso;
=======
	BorderPane paneRemoverFilme;
>>>>>>> 8432f6832531133fc7b43cda80ed3c8424830849
	
	
	
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
			adicionarSala = new FXMLLoader(this.getClass().getResource("AdicionarSala.fxml"));
			this.paneAdicionarSala = adicionarSala.load();
			adicionarSessao = new FXMLLoader(this.getClass().getResource("AdicionarSessao.fxml"));
			this.paneAdicionarSessao = adicionarSessao.load();
			removerSala = new FXMLLoader(this.getClass().getResource("RemoverSala.fxml"));
			this.paneRemoverSala = removerSala.load();
			removerSessao = new FXMLLoader(this.getClass().getResource("RemoverSessao.fxml"));
			this.paneRemoverSessao = removerSessao.load();
<<<<<<< HEAD
			comprarIngresso = new FXMLLoader(this.getClass().getResource("ComprarIngresso.fxml"));
			this.paneComprarIngresso = comprarIngresso.load();
=======
			removerFilme = new FXMLLoader(this.getClass().getResource("RemoverFilme.fxml"));
			this.paneRemoverFilme = removerFilme.load();
>>>>>>> 8432f6832531133fc7b43cda80ed3c8424830849
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
	
	public void getAdicionarSala(){
		border.setCenter(this.paneAdicionarSala);
	}
	
	public void getAdicionarSessao(){
		border.setCenter(this.paneAdicionarSessao);
	}
	
	public void getRemoverSala(){
		border.setCenter(this.paneRemoverSala);
	}
	
	public void getRemoverSessao(){
		border.setCenter(this.paneRemoverSessao);
	}
	
<<<<<<< HEAD
	public void getComprarIngresso(){
		border.setCenter(this.paneComprarIngresso);
	}
	
=======
	public void getRemoverFilme(){
		border.setCenter(this.paneRemoverFilme);
	}
>>>>>>> 8432f6832531133fc7b43cda80ed3c8424830849
	
	
}
