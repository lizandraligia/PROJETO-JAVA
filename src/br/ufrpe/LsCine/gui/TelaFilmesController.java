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
	
	public void filme(){
		try{
			Telas.getInstance().getTelaFilmes();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void sala(){
		try{
			Telas.getInstance().getTelaSalas();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void sessao(){
		try{
			Telas.getInstance().getTelaSessao();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void financeiro(){
		try{
			Telas.getInstance().getFinanceiro();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
