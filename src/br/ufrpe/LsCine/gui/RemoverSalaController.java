package br.ufrpe.LsCine.gui;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import br.ufrpe.LsCine.negocio.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class RemoverSalaController implements Initializable {
	
	private Fachada fachada = Fachada.getInstancia();
	@FXML JFXTextField IDSala;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void remover(){
		try{
		fachada.getInstancia().getCadastroSa().remover(Integer.parseInt(IDSala.getText()));	
		
		for(int i=0; i<fachada.getInstancia().getCadastroSa().listar().size(); i++){
			System.out.println(fachada.getInstancia().getCadastroSa().listar().get(i).toString());
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removerb(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmar exclusão");
		alert.setHeaderText("Você tem certeza de que quer excluir?");
		alert.setContentText(fachada.getInstancia().getCadastroSa().procurarId(Integer.parseInt(IDSala.getText())).toString());

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