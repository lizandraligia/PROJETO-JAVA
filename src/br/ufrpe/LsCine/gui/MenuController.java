package br.ufrpe.LsCine.gui;

import java.net.URL;
import java.util.ResourceBundle;
import br.ufrpe.LsCine.negocio.Fachada;
import javafx.fxml.Initializable;

public class MenuController implements Initializable{

	private Fachada fachada = Fachada.getInstancia();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
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
	
	public void adicionarSala(){
		try{
			Telas.getInstance().getAdicionarSala();
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

	public void financeiro(){
		try{
			Telas.getInstance().getFinanceiro();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
