package br.ufrpe.LsCine.gui;

import java.io.IOException;

import br.ufrpe.LsCine.negocio.beans.Sessao;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class Telas {

	BorderPane paneLogin;
	BorderPane border;
	FXMLLoader login, menu, adicionarFilme, financeiro, adicionarSala, adicionarSessao, adicionado,
				removerSala, removerSessao, comprarIngresso,  removerFilme, telaFilmes, telaSalas, telaSessao, editarSessao;
	BorderPane paneMenu;
	BorderPane paneAdicionarFilme; 
	BorderPane paneFinanceiro;
	BorderPane paneAdicionarSala;
	BorderPane paneAdicionarSessao;
	BorderPane paneRemoverSala;
	BorderPane paneRemoverSessao;
	BorderPane paneComprarIngresso;
	BorderPane paneRemoverFilme;
	BorderPane paneTelaFilmes;
	BorderPane paneTelaSalas;
	BorderPane paneTelaSessao;
	BorderPane paneEditarSessao;
	
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
			comprarIngresso = new FXMLLoader(this.getClass().getResource("ComprarIngresso.fxml"));
			this.paneComprarIngresso = comprarIngresso.load();
			removerFilme = new FXMLLoader(this.getClass().getResource("RemoverFilme.fxml"));
			this.paneRemoverFilme = removerFilme.load();
			telaFilmes = new FXMLLoader(this.getClass().getResource("TelaFilmes.fxml"));
			this.paneTelaFilmes = telaFilmes.load();
			telaSalas = new FXMLLoader(this.getClass().getResource("TelaSalas.fxml"));
			this.paneTelaSalas = telaSalas.load();
			telaSessao = new FXMLLoader(this.getClass().getResource("TelaSessao.fxml"));
			this.paneTelaSessao = telaSessao.load();
			editarSessao = new FXMLLoader(this.getClass().getResource("EditarSessao.fxml"));
			this.paneEditarSessao = editarSessao.load();
			this.border = Main.getRoot();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public FXMLLoader getFilme(){
		return this.menu;
	}
	
	public void getLogin(){	
		border.setCenter(this.paneLogin);	
	}
	
	public void getMenu(){	
		border.setCenter(this.paneMenu);
		MenuController controlador = this.getFilme().getController();
		controlador.tabela();
	}
	
	public void getTelaFilmes(){
		border.setCenter(this.paneTelaFilmes);
	}
	
	public void getTelaSalas(){
		border.setCenter(this.paneTelaSalas);
	}
	
	public void getTelaSessao(){
		border.setCenter(this.paneTelaSessao);
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
		AdicionarSessaoController controlador = adicionarSessao.getController();
		controlador.atualizar();
	}
	
	public void getRemoverSala(){
		border.setCenter(this.paneRemoverSala);
	}
	
	public void getRemoverSessao(){
		border.setCenter(this.paneRemoverSessao);
	}

	public void getEditarSessao(){
		 border.setCenter(this.paneEditarSessao);
		 EditarSessaoController controlador = editarSessao.getController();
		controlador.atualizar();
	}
	
	public void getComprarIngresso(Sessao sessao){
		border.setCenter(this.paneComprarIngresso);
		ComprarIngressoController controlador = comprarIngresso.getController();
		controlador.setSessao(sessao);
		controlador.atualizarSessao();
		
	}
	
	public void getRemoverFilme(){
		border.setCenter(this.paneRemoverFilme);
	}	
	
}
