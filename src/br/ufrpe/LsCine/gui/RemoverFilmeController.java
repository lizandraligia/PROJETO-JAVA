package br.ufrpe.LsCine.gui;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import br.ufrpe.LsCine.negocio.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class RemoverFilmeController implements Initializable{

	private Fachada fachada = Fachada.getInstancia();
	@FXML JFXTextField tfNome;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void remover(){
		try{
			Fachada.getInstancia().getCadastroF().remover(tfNome.getText());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removerb(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmar exclusão");
		alert.setHeaderText("Você tem certeza de que quer excluir?");
		alert.setContentText(Fachada.getInstancia().getCadastroF().buscar(tfNome.getText()).toString());

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    this.remover();
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
