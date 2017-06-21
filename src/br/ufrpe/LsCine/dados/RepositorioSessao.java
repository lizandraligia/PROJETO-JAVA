package br.ufrpe.LsCine.dados;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.LsCine.negocio.beans.Sessao;

public class RepositorioSessao {
	
	private Sessao[] sessao;
	private int lim;
	
	
	public RepositorioSessao() {
		this.sessao = new Sessao[100];
		this.lim = 0;
	}
	
	
	//CRIEI METODOS GET 
	public Sessao[] getSessao() {
		return sessao;
	}

	public int getLim() {
		return lim;
	}

	//MUDEI O RETORNO DE void PARA boolean
	public boolean adicionar(Sessao sessao){
		
		//System.out.println();
		/*if (sessao == null) {
			//System.out.println("Sessão inválida");
			return;
		}
		
		if(sessao.getSala().getTipo().equals("IMAX 3D")){
			if(this.lim == 2) {
				//System.out.println("Sala lotada!");
				return;
			}
		}
		
		if(sessao.getSala().getTipo().equals("IMAX 2D")){
			if(this.lim == 2) {
				//System.out.println("Sala lotada!");
				return;
			}
		}
		
		if(sessao.getSala().getTipo().equals("3D")){
			if(this.lim == 4) {
				//System.out.println("Sala lotada!");
				return;
			}
		}*/
		

		if(this.lim < 5) {
			this.sessao[lim] = sessao;
			this.lim++;
			//System.out.println("Sessão cadastrada com sucesso!");
			return true;
		}else{
			//System.out.println("Sala lotada!");
			return false;
		}
	}
	
	//MUDEI O RETORNO DE void PARA BOOLEAN
	public boolean remover(int id){
		int SessaoRemover = this.retornarPosicao(id);
		
		if (SessaoRemover == -1) {
			//System.out.println("Sala não encontrada.");
			return false;
		}
		
		this.sessao[SessaoRemover] = this.sessao[this.lim -1];
		this.sessao[this.lim - 1] = null;
		this.lim = this.lim - 1;
		
		//System.out.println("Sala removida com sucesso.");
		return true;
	}
	
	//MUDEI O RETORNO DE void PARA BOOLEAN
	public boolean alterar(Sessao sessao){
		int sessaoalterar = this.retornarPosicao(sessao.getId());
		if (sessaoalterar == -1) {
			//System.out.println("Sala inexistente.");
			return false;
		}
		this.sessao[sessaoalterar] = sessao;
		//System.out.println("Sala alterada.");
		return true;
	}
	
	/*public int pesquisar(Sessao sessao){
		return this.sessao.indexOf(sessao);
	}*/
	
	private int retornarPosicao(int numero) {		
		for (int i = 0; i< this.lim; i++){
			int cod = sessao[i].getId();
			if (numero == cod) {
				return i;
			} 
		}
		
		return -1;
	}
	
	public void listar() {
		//System.out.println();
		//System.out.println("Todos as salas cadastradas são: ");
		for(int i = 0; i<lim; i++){
			System.out.println(sessao[i].toString());
			System.out.println();			
		}
	}

}
