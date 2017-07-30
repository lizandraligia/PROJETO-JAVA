package br.ufrpe.LsCine.dados;

import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.interfaces.IRepositorioFilme;
import java.util.ArrayList;

public class RepositorioFilme implements IRepositorioFilme{

	private ArrayList<Filme> filmes;
	
	public RepositorioFilme(){
		this.filmes = new ArrayList<Filme>();
	}

	public ArrayList<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}

	public boolean inserirFilme(Filme filme){
		this.filmes.add(filme);
		return true;
	}
	
	public Filme buscarFilme(String nome){
		if(nome == null){
			return null;
		}
		for (int i = 0; i<filmes.size() ; i++){	
			if(nome.equals(filmes.get(i).getNome())){
				return filmes.get(i);
			}
		}			
		return null;
	}
	
	public boolean removerFilme(String nome){
		if(nome==null){
			return false;
		}
		Filme posicao = this.buscarFilme(nome);
		if(posicao != null){
			this.filmes.remove(posicao);
			return true;
		}
		return false;
		
	}
	
	public boolean editarFilme(Filme filme){ 
		if(filme==null){
			return false;
		}
		Filme atualizar = this.buscarFilme(filme.getNome());
		this.filmes.set(this.filmes.indexOf(atualizar), filme);
		return true;
	}

	
	public ArrayList<Filme> listar(){
		return this.filmes;
	}
}
