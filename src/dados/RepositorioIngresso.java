package dados;

import negocio.beans.Ingresso;

public class RepositorioIngresso {
	
	private final static int QTD_INGRESSOS = 100;
	int contagemIngresso;
	Ingresso[] ingresso;
	
	public RepositorioIngresso(){
		this.contagemIngresso = 0;
		this.ingresso = new Ingresso[QTD_INGRESSOS];
	}
	
	public void vendaIngresso(){
		this.contagemIngresso++;
		
		//falta ir removendo ingressos disponiveis do array de cada sessao
	}

	public boolean inserirVenda(Ingresso ingresso){
		
		this.ingresso[this.contagemIngresso]=ingresso;
		this.contagemIngresso++;
		return true;
	}
	
	public int getContagemIngresso() {
		return contagemIngresso;
	}
	
}
