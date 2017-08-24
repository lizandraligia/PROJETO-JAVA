package br.ufrpe.LsCine.gui;

import br.ufrpe.LsCine.exceptions.ValorInvalidoException;
import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Filme;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Alert;

public class AdicionarFilmeController{
	
	private Fachada fachada = Fachada.getInstancia();
	
	@FXML JFXTextField tfNome, tfDuracao;
	@FXML JFXComboBox <String> cbClassificacao; 
	@FXML ObservableList<String> list = FXCollections.observableArrayList("Livre","+10","+12","+14","+16","+18");	
	
	@FXML
	public void initialize() {
		cbClassificacao.setItems(list);
	}
	
	public void inserir() throws ValorInvalidoException{
		try{
			Filme f = new Filme();
			f.setNome(tfNome.getText());
			f.setDuracao(Integer.valueOf(tfDuracao.getText()));
			f.setClassificacao(cbClassificacao.getValue());
			Fachada.getInstancia().getCadastroF().cadastrar(f);
			//fachada.getInstancia().getCadastroF().cadastrar(f);
			
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			Stage stage = (Stage) dialogoInfo.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(this.getClass().getResource("/br/ufrpe/LsCine/imagens/Logo.png").toString()));
        	dialogoInfo.setTitle("Filme adicionado com sucesso!");
        	dialogoInfo.setHeaderText(null);
        	dialogoInfo.setContentText(f.toString());
        	dialogoInfo.showAndWait();
			
		}
		catch(Exception ValorInvalidoException){
			//System.out.println(e.getMessage());
			throw new ValorInvalidoException();
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
	
	public void financeiro(){
		try{
			Telas.getInstance().getFinanceiro();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
