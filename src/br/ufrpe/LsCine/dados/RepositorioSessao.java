package br.ufrpe.LsCine.dados;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.LsCine.negocio.beans.Sessao;

public class RepositorioSessao {
	
	
	private ArrayList<Sessao> sessao;
	private int lim;
	
	public RepositorioSessao() {
		this.sessao = new ArrayList<Sessao>();
		this.lim = 0;
	}
	
	
	//CRIEI METODOS GET 
	public ArrayList<Sessao> getSessao() {
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
			this.sessao.add(sessao);
			this.lim++;
			//System.out.println("Sessão cadastrada com sucesso!");
			return true;
		}else{
			//System.out.println("Sala lotada!");
			return false;
		}
	}
	
	//MUDEI O RETORNO DE void PARA BOOLEAN
	public boolean remover(Sessao sessao){
		int search = pesquisar(sessao);
		if (search != -1) {
			this.sessao.remove(sessao);
			//System.out.println("Sessão excluída.");
			return true;
		}
		//System.out.println("Sessão não encontrada.");
		return false;
	}
	
	//MUDEI O RETORNO DE void PARA BOOLEAN
	public boolean alterar(Sessao sessao){
		int search = pesquisar(sessao);
		if (search != -1) {
			this.sessao.set(search, sessao);
			//System.out.println("Sessão alterada.");
			return true;
		}
		//System.out.println("Sessão não encontrada.");
		return false;
	}
	
	public int pesquisar(Sessao sessao){
		return this.sessao.indexOf(sessao);
	}
	
	public List<Sessao> listar() {
		List<Sessao> listaOrdenada = this.sessao;
		return listaOrdenada;
	}


}
