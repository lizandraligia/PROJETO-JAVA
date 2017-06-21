package br.ufrpe.LsCine.dados;
import java.util.ArrayList;
import br.ufrpe.LsCine.negocio.beans.Conta;

public class RepositorioConta {

	private ArrayList<Conta> contas;
	
	public RepositorioConta(){
		Conta user = new Conta("admin","admin");
		this.contas = new ArrayList<Conta>();
		this.contas.add(user);
	}
	
	public ArrayList<Conta> getContas() {
		return this.contas;
	}
	
	public boolean adicionar(Conta conta){
		if(this.pesquisar(conta) == -1){
			if(conta.getLogin() != null && conta.getSenha() != null){
				this.contas.add(conta);
				return true;
			}
		}
		return false;
	}
	
	public boolean remover(Conta conta){
		int search = pesquisar(conta);
		if (search != -1) {
			this.contas.remove(conta);
			return true;
		}
		return false;
	}
	
	public int pesquisar(Conta conta){
		for(int i = 0; i < this.contas.size(); i++){
			if(this.contas.get(i).getLogin().equals(conta.getLogin())){
				if(this.contas.get(i).getSenha().equals(conta.getSenha())){
					return i;
				}
			}
		}
		return -1;
	}
}
