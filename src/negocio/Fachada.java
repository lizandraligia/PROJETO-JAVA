package negocio;

import negocio.beans.Filme;
import negocio.beans.Ingresso;

public class Fachada {

	private CadastroFilme cadastroF;
	private CadastroIngresso cadastroI;
	
	public Fachada(){
		this.cadastroF = new CadastroFilme();
		this.cadastroI = new CadastroIngresso();
	}
	
	public boolean cadastrarFilme(Filme filme){
		return this.cadastroF.cadastrar(filme);
	}
	
	public Filme buscarFilme(String nome){
		return this.cadastroF.buscar(nome);
	}
	
	public boolean existeFilme(String nome){
		return this.cadastroF.existe(nome);
	}
	
	public boolean removerFilme(String nome){
		return this.cadastroF.remover(nome);
	}
	
	public boolean editarFilme(Filme filme){
		return this.cadastroF.editar(filme);
	}
	/*
	public void listarFilme(){
		return this.cadastroF.lista();
	}*/
	
	public boolean cadastrarIngresso(Ingresso ingresso){
		return this.cadastroI.cadastrar(ingresso);
	}
	
	public boolean removerIngresso(int id){
		return this.cadastroI.remover(id);
	}
	
	public float totalFinanceiroIngresso(){
		return this.cadastroI.totalFinanceiro();
	}
	
}
