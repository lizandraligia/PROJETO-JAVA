package br.ufrpe.LsCine.exceptions;

public class FilmeExistenteException extends Exception {
	
	public FilmeExistenteException() {
		
		super("Filme ja cadastrado no sistema.");
	}
	
}
