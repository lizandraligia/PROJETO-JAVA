package br.ufrpe.LsCine.dados;

import br.ufrpe.LsCine.negocio.beans.Conta;
import java.util.ArrayList;
import br.ufrpe.LsCine.interfaces.IRepositorioConta;

public class RepositorioConta implements IRepositorioConta{

	private ArrayList<Conta> contas;
	
	public RepositorioConta(){
		Conta user = new Conta("admin","admin");
		this.contas = new ArrayList<Conta>();
		this.contas.add(user);
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	public boolean adicionar(Conta conta){
		this.contas.add(conta);
		return true;

	}
	
	public Conta buscar(Conta conta){
		if(conta == null){
			return null;
		}
		for (int i = 0; i<contas.size() ; i++){	
			if(conta.equals(contas.get(i).getLogin())){
				if(conta.equals(contas.get(i).getSenha())){
				return contas.get(i);
				}
			}			
		}
		return null;
	}
	
	
	public boolean remover(Conta login) {
		if(login==null){
			return false;
		}
		Conta posicao = this.buscar(login);
		if(posicao != null){
			this.contas.remove(posicao);
			return true;
		}
		return false;	
	}
}
