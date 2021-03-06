package br.ufrpe.LsCine.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SessaoException extends Exception{

	public SessaoException() {
		Alert alert = new Alert(AlertType.INFORMATION);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(this.getClass().getResource("/br/ufrpe/LsCine/imagens/Logo.png").toString()));
		alert.setTitle("LsCine");
		alert.setHeaderText(null);
		alert.setContentText("Impossível adicionar a sessao! Verifique o horário e tente novamente!");
		alert.showAndWait();
	}
}
