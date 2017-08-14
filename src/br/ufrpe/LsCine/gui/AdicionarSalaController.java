package br.ufrpe.LsCine.gui;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXCheckBox;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Salas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class AdicionarSalaController implements Initializable {
	
	private Fachada fachada = Fachada.getInstancia();
	
	@FXML JFXTextField JXID;
	@FXML JFXCheckBox s3D = new JFXCheckBox();
	@FXML JFXCheckBox IMAX = new JFXCheckBox();
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void inserir(){
		try{
			Salas sala = new Salas(Integer.parseInt(JXID.getText()), s3D.selectedProperty().get(), IMAX.selectedProperty().get());
			fachada.getInstancia().getCadastroSa().adicionar(sala);
			System.out.println("adicionado");
			
			for(int i=0; i<fachada.getInstancia().getCadastroSa().listar().size(); i++){
				System.out.println(fachada.getInstancia().getCadastroSa().listar().get(i).toString());
			}
			
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
	        dialogoInfo.setTitle("A SALA FOI ADICIONADA COM SUCESSO!");
	        dialogoInfo.setHeaderText(null);
	        dialogoInfo.setContentText(sala.toString());
	        dialogoInfo.showAndWait();
			
			
		}catch(Exception e){
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
