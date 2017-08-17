package br.ufrpe.LsCine.gui;

public class FinanceiroController {
  
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
