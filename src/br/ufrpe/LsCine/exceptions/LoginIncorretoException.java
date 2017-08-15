package br.ufrpe.LsCine.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginIncorretoException extends Exception{

	public LoginIncorretoException(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("LsCine");
		alert.setHeaderText(null);
		alert.setContentText("Login incorreto. Tente novamente.");
		alert.showAndWait();
		//super("Login incorreto.");
	}
}
