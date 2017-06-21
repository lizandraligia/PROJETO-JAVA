package br.ufrpe.LsCine.dados;

import br.ufrpe.LsCine.negocio.beans.Ingresso;

public class RepositorioIngresso {
	
	private final static int QTD_INGRESSOS = 200;
	int contagemIngresso;
	Ingresso[] ingresso;
	
	public RepositorioIngresso(){
		this.contagemIngresso = 0;
		this.ingresso = new Ingresso[QTD_INGRESSOS];
	}

	public boolean inserir(Ingresso ingresso){
		
		this.ingresso[this.contagemIngresso]=ingresso;
		this.contagemIngresso++;
		return true;
	}
	
	private int retornarPosicao(int id) {
		if (id<0){
			return -1;
		}
		for (int i = 0; i< this.contagemIngresso; i++){
			if(id == ingresso[i].getId()){
				return i;
			}
		}	
		return -1;
	}
	
	public Ingresso buscar(int id){
		int posicao = this.retornarPosicao(id);		
		return (posicao!=-1) ? this.ingresso[posicao] : null; 
	}
	
	public boolean remover(int id){
		int posicaoRemover = this.retornarPosicao(id);
		
		if (posicaoRemover == -1) {
			return false;
		}	
		this.ingresso[posicaoRemover] = this.ingresso[this.contagemIngresso -1];
		this.ingresso[this.contagemIngresso - 1] = null;
		this.contagemIngresso = this.contagemIngresso - 1;	
		return true;
	}
	
	public int getContagemIngresso() {
		return contagemIngresso;
	}
	
	public void listaVendas(){
		for (Ingresso lista : ingresso) {
			System.out.println(lista);
		}
	}
	
	public float financeiroIngresso(){
		float valor = 0;
		for (int i = 0; i< this.contagemIngresso; i++){
			valor+=this.ingresso[i].getValor();
		}
		return valor;
	}
}
