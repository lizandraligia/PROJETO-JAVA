package br.ufrpe.LsCine.gui;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Ingresso;
import br.ufrpe.LsCine.negocio.beans.Sessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class ComprarIngressoController implements Initializable {
	
private Fachada fachada = Fachada.getInstancia();
	
	@FXML JFXTextField IDS;
	@FXML JFXTextField Letra;
	@FXML JFXTextField Num;
	@FXML JFXToggleButton Meia;
	
	@FXML ListView<Sessao> list = new ListView<Sessao>();
	ObservableList<Sessao> items =FXCollections.observableArrayList(fachada.getInstancia().getCadastroSe().listar());
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		list.setItems(items);
	}
	
	public void comprar(){		
		try{
			int x;
			if(Meia.isSelected()){
				x = 2;
			}else{
				x = 1;
			}
			Sessao sessao = fachada.getInstancia().getCadastroSe().procurarID(Integer.parseInt(IDS.getText()));
			int lugar = this.assento(Letra.getText(), Integer.parseInt(Num.getText()));
			int id = fachada.getInstancia().getCadastroI().listar().size();			
			Ingresso ingresso = new Ingresso(x, this.valor(), sessao, lugar, id);
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmar Compra");
			alert.setHeaderText("Voc� tem certeza de que quer comprar o ingresso?");
			alert.setContentText(ingresso.toString());

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				fachada.getInstancia().getCadastroI().cadastrar(ingresso);	
			}			
							
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public float valor(){
		Date dia = new Date();
		int d = dia.getDay();
		if(d == 1 || d == 2){
			return 24;
		}
		if(d == 3){
			return 20;
		}
		if(d == 4 || d == 5 || d == 6 || d == 0){
			return 27;
		}
		return 0;
	}
	
	public int assento(String fila, int num){
		int x;
		switch(fila){
		case "A":
			return num-1;
		case "B":
			x = 19 + num;
			return x;
		case "C":
			x = 39 + num;
			return x;
		case "D":
			x = 59 + num;
			return x;
		case "E":
			x = 79 + num;
			return x;
		case "F":
			x = 99 + num;
			return x;
		case "G":
			x = 119 + num;
			return x;
		case "H":
			x = 139 + num;
			return x;
		case "I":
			x = 159 + num;
			return x;
		case "J":
			x = 179 + num;
			return x;	
		}
		return -1;
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