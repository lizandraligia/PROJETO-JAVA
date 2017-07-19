package br.ufrpe.LsCine.dados;

import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.interfaces.IRepositorioFilme;

public class RepositorioFilme implements IRepositorioFilme{

	private final static int QTD_FILMES = 5;
	private int contadorFilmes;
	private Filme[] filmes;
	
	public RepositorioFilme(){
		this.contadorFilmes = 0;
		this.filmes = new Filme[QTD_FILMES];
	}

	public boolean inserirFilme(Filme filme){
		
		this.filmes[this.contadorFilmes]=filme;
		this.contadorFilmes++;
		return true;
	}
	
	public boolean existe(String nome) {
		return this.retornarPosicao(nome)!=-1;
	}
	
	private int retornarPosicao(String nome) {
		if (nome == null){
			return -1;
		}
		for (int i = 0; i< this.contadorFilmes; i++){
			if(nome.equals(filmes[i].getNome())){
				return i;
			}
		}	
		return -1;
	}
	
	public Filme buscarFilme(String nome){
		int posicao = this.retornarPosicao(nome);		
		return (posicao!=-1) ? this.filmes[posicao] : null; 
	}
	
	public boolean removerFilme(String nome){
		int posicaoRemover = this.retornarPosicao(nome);
		
		if (posicaoRemover == -1) {
			return false;
		}	
		this.filmes[posicaoRemover] = this.filmes[this.contadorFilmes -1];
		this.filmes[this.contadorFilmes - 1] = null;
		this.contadorFilmes = this.contadorFilmes - 1;	
		return true;
	}
	
	public boolean editarFilme(Filme filme){ 

		int posicaoAtualizar = this.retornarPosicao(filme.getNome());
		if (posicaoAtualizar == -1) {
			return false;
		}
		this.filmes[posicaoAtualizar] = filme;
		return true;
	}
	
	public void listarFilmes(){
		for (Filme lista : filmes) {
			System.out.println(lista);
		}
	}
}
