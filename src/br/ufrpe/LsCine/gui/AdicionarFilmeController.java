package br.ufrpe.LsCine.gui;


import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Filme;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class AdicionarFilmeController implements Initializable{
	
	private Fachada fachada = Fachada.getInstancia();
	
	@FXML TextField tfNome, tfDuracao;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void inserir(){
		try{
			Filme f = new Filme();
			f.setNome(tfNome.getText());
			f.setDuracao(Integer.valueOf(tfDuracao.getText()));
			fachada.getInstancia().getCadastroF().cadastrar(f);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void voltar(){
		try{
			Telas.getInstance().getMenu();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
