package br.ufrpe.LsCine.exceptions;

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
