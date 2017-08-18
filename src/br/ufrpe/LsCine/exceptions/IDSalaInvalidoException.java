package br.ufrpe.LsCine.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class IDSalaInvalidoException extends Exception {
	
	public IDSalaInvalidoException() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("LsCine");
		alert.setHeaderText(null);
		alert.setContentText("ID inválido ou repetido! Digite novamente!");
		alert.showAndWait();
	}
}
