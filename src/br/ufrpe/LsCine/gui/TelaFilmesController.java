package br.ufrpe.LsCine.gui;

public class TelaFilmesController {
	
	public void adicionar(){
		try{
			Telas.getInstance().getAdicionarFilme();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void remover(){
		try{
			Telas.getInstance().getRemoverFilme();
			System.out.println("funfou");
		}
		catch(Exception e){
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
