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
		
		
	public void financeiro(){	
		try{	
			this.fachada.totalFinanceiroIngresso();
			Visual.getInstance();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void sair(){
		try{
			Visual.getInstance().getLogin();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	
}
