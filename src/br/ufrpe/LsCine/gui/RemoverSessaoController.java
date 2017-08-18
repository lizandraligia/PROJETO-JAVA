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
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RemoverSessaoController implements Initializable {

	private Fachada fachada = Fachada.getInstancia();
	@FXML JFXTextField IDSessao;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void remover(){
		try{
		fachada.getInstancia().getCadastroSe().removerSessao(Integer.parseInt(IDSessao.getText()));	
		
		for(int i=0; i<fachada.getInstancia().getCadastroSe().listar().size(); i++){
			System.out.println(fachada.getInstancia().getCadastroSe().listar().get(i).toString());
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removerb(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(this.getClass().getResource("/br/ufrpe/LsCine/imagens/Logo.png").toString()));
		alert.setTitle("Confirmar exclusão");
		alert.setHeaderText("Você tem certeza de que quer excluir?");
		alert.setContentText(fachada.getInstancia().getCadastroSe().procurarID(Integer.parseInt(IDSessao.getText())).toString());

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
	
	public void filme(){
		try{
			Telas.getInstance().getTelaFilmes();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void sala(){
		try{
			Telas.getInstance().getTelaSalas();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void sessao(){
		try{
			Telas.getInstance().getTelaSessao();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
