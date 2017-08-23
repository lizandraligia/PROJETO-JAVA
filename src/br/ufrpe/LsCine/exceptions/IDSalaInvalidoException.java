package br.ufrpe.LsCine.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class IDSalaInvalidoException extends Exception {
	
	public IDSalaInvalidoException() {
		Alert alert = new Alert(AlertType.INFORMATION);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(this.getClass().getResource("/br/ufrpe/LsCine/imagens/Logo.png").toString()));
		alert.setTitle("LsCine");
		alert.setHeaderText(null);
		alert.setContentText("ID inválido ou repetido! Digite novamente!");
		alert.showAndWait();
	}
}
