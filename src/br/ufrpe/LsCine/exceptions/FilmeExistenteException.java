package br.ufrpe.LsCine.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FilmeExistenteException extends Exception {
	
	public FilmeExistenteException() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("LsCine");
		alert.setHeaderText(null);
		alert.setContentText("Filme ja cadastrado no sistema.");
		alert.showAndWait();
		//super("Filme ja cadastrado no sistema.");
	}
	
}
