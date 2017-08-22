package br.ufrpe.LsCine.gui;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.negocio.beans.Salas;
import br.ufrpe.LsCine.negocio.beans.Sessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AdicionarSessaoController implements Initializable {
	
	private Fachada fachada = Fachada.getInstancia();
	
	@FXML JFXTextField ID;
	@FXML JFXTextField HORAINI;
	@FXML JFXTextField HORAFIM;
	@FXML JFXToggleButton leg;
	@FXML JFXComboBox <Filme> cbFilmes; 
	@FXML JFXComboBox <Salas> cbSalas; 
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void atualizar(){
		cbFilmes.setItems(FXCollections.observableArrayList(fachada.listarFilme()));
		cbSalas.setItems(FXCollections.observableArrayList(fachada.listarSalas()));
		ID.setText(String.valueOf(fachada.listarSessoes().size() + 1));
	}
	
	public void inserir(){
		try{
			Filme filmes = cbFilmes.getValue();
			Salas salan = cbSalas.getValue();
			Date data = new Date();
			Date data2 = new Date();
			int final1 = filmes.getDuracao();
			final1 = final1 / 60;
			int hrsfim = Integer.parseInt(HORAINI.getText()) + final1;
			int final2 = filmes.getDuracao();
			final2 = final2 % 60;
			int minfim = Integer.parseInt(HORAFIM.getText()) + final2;
			data.setHours(Integer.parseInt(HORAINI.getText()));
			data.setMinutes(Integer.parseInt(HORAFIM.getText()));
			data2.setHours(hrsfim);
			data2.setMinutes(minfim);			
			Sessao sessao = new Sessao(filmes, salan, data, data2, fachada.listarSessoes().size() + 1, leg.isSelected());
			fachada.getInstancia().getCadastroSe().adicionarSessao(sessao);
			
			for(int i=0; i<fachada.getInstancia().getCadastroSe().listar().size(); i++){
				System.out.println(fachada.getInstancia().getCadastroSe().listar().get(i).toString());
			}
			
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			Stage stage = (Stage) dialogoInfo.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(this.getClass().getResource("/br/ufrpe/LsCine/imagens/Logo.png").toString()));
	        dialogoInfo.setTitle("A SESSÃO FOI ADICIONADA COM SUCESSO!");
	        dialogoInfo.setHeaderText(null);
	        dialogoInfo.setContentText(sessao.toString());
	        dialogoInfo.showAndWait();
			
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
