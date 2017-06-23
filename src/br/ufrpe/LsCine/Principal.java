package br.ufrpe.LsCine;
import  br.ufrpe.LsCine.gui.Tela;

public class Principal {

	public static void main(String[] args) {
		
		//Tela tela = new Tela();
		//tela.menu();
		
		Tela tela = Tela.getInstancia();
		Fachada fachada = Fachada.getInstancia();
		tela.menu();
	}
}
