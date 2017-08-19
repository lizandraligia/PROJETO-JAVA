package br.ufrpe.LsCine.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.negocio.beans.Salas;
import br.ufrpe.LsCine.negocio.beans.Sessao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class MenuController{

	private Fachada fachada = Fachada.getInstancia();
	
	@FXML TableView <Sessao> tabela;
	@FXML TableColumn <Sessao, String> tcNome, tcHorario, tcClas, tcSala;
	//@FXML TableColumn <Filme, Integer> tcDur;
	
	@FXML
	public void initialize() {
		tabela.setOnMouseClicked(new EventHandler<MouseEvent>() {

        @Override
	        public void handle(MouseEvent event) {
	        	tabela.getSelectionModel().getSelectedItem();
	        	comprarIngresso();
	        }
		});
	}
	
		
	public void tabela(){
		
		tcNome.setCellValueFactory(new PropertyValueFactory<Sessao, String>("nome"));
		tcHorario.setCellValueFactory(new PropertyValueFactory<Sessao, String>("hrinicio"));
		tcSala.setCellValueFactory(new PropertyValueFactory<Sessao, String>("tipo"));
		//tcDur.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("duracao"));
		tcClas.setCellValueFactory(new PropertyValueFactory<Sessao, String>("classificacao"));
		
		tabela.setItems(FXCollections.observableList(Fachada.getInstancia().getCadastroSe().getRepositorioSessao().listar()));
		tabela.refresh();
	}
	
/*	
	public void clique(){
		
		Sessao sessao = tabela.getSelectionModel().getSelectedItem();
		String nome = sessao.getNome();
		String clas = sessao.getClassificacao();
		String tipo = sessao.getTipo();
		String hora = sessao.getHrinicio();
		System.out.println(tabela.getOnMouseClicked());
		//tabela.getSelectionModel().getSelectedItem().toString();
	}*/
	
	@FXML 
	public void handleMouseClick(MouseEvent arg0) throws IOException {

	}
	
	public void home(){
		try{
			Telas.getInstance().getMenu();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void sair(){
		try{
			Telas.getInstance().getLogin();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void filme(){
		try{
			Telas.getInstance().getTelaFilmes();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void salas(){
		try{
			Telas.getInstance().getTelaSalas();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void sessao(){
		try{
			Telas.getInstance().getTelaSessao();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/*
	public void adicionarFilme(){
		try{
			Telas.getInstance().getAdicionarFilme();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	*/
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
