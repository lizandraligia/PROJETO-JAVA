package br.ufrpe.LsCine.gui;

import java.net.URL;
import java.util.ResourceBundle;
import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Filme;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuController implements Initializable{

	private Fachada fachada = Fachada.getInstancia();
	
	@FXML TableView <Filme> tabela;
	@FXML TableColumn <Filme, String> tcFilme, tcClas, tcIdioma;
	@FXML TableColumn <Filme, Integer> tcDur;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
		
	public void tabela(){
		tcFilme.setCellValueFactory(new PropertyValueFactory<Filme, String>("nome"));
		tcDur.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("duracao"));
		tcClas.setCellValueFactory(new PropertyValueFactory<Filme, String>("classificacao"));
		tcIdioma.setCellValueFactory(new PropertyValueFactory<Filme, String>("idioma"));
		
		tabela.setItems(FXCollections.observableList(Fachada.getInstancia().getCadastroF().getRepositorioF().listar()));
		tabela.refresh();
	}
	
	public void home(){
		try{
			Telas.getInstance().getMenu();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	/*
	public void financeiro(){	
		try{	
			this.fachada.totalFinanceiroIngresso();
			Visual.getInstance().getMenu();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}*/
	
	public void sair(){
		try{
			Telas.getInstance().getLogin();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void adicionarFilme(){
		try{
			Telas.getInstance().getAdicionarFilme();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removerFilme(){
		try{
			Telas.getInstance().getRemoverFilme();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void adicionarSala(){
		try{
			Telas.getInstance().getAdicionarSala();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removerSala(){
		try{
			Telas.getInstance().getRemoverSala();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void adicionarSessao(){
		try{
			Telas.getInstance().getAdicionarSessao();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removerSessao(){
		try{
			Telas.getInstance().getRemoverSessao();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void comprarIngresso(){
		try{
			Telas.getInstance().getComprarIngresso();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void financeiro(){
		try{
			Telas.getInstance().getFinanceiro();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
}
