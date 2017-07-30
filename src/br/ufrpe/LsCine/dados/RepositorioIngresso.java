package br.ufrpe.LsCine.dados;

import br.ufrpe.LsCine.negocio.beans.Ingresso;
import br.ufrpe.LsCine.interfaces.IRepositorioIngresso;
import java.util.ArrayList;

public class RepositorioIngresso implements IRepositorioIngresso{
	
	private ArrayList<Ingresso> ingressos;
	
	public RepositorioIngresso(){
		this.ingressos = new ArrayList<Ingresso>();
	}

	public ArrayList<Ingresso> getIngresso() {
		return ingressos;
	}
	
	public void setIngresso(ArrayList<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public boolean inserir(Ingresso ingresso){	
		this.ingressos.add(ingresso);
		return true;
	}

	public Ingresso buscar(int id){
		if(id<0){
			return null;
		}
		for (int i = 0; i < ingressos.size() ; i++){	
			if(id==ingressos.get(i).getId()){
				return ingressos.get(i);
			}
		}			
		return null;
	}
	
	public boolean remover(int id){
		if(id<0){
			return false;
		}
		Ingresso posicao = this.buscar(id);
		if(posicao != null){
			this.ingressos.remove(posicao);
			return true;
		}
		return false;
	}
	
	public ArrayList<Ingresso> listaVendas(){
		return this.ingressos;
	}
	
	public float financeiroIngresso(){
		float valor = 0;
		for (int i = 0; i<ingressos.size(); i++){
			valor+=this.ingressos.get(i).getValor();
		}
		return valor;
	}
}
