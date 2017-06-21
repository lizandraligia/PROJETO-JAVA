package br.ufrpe.LsCine.negocio;
import br.ufrpe.LsCine.negocio.beans.Conta;
import br.ufrpe.LsCine.dados.RepositorioConta;

public class CadastroConta {

private RepositorioConta repositorioConta;
	
	public CadastroConta(){
		this.repositorioConta = new RepositorioConta();
	}
	
	public boolean logar(String login, String senha){
		Conta conta = new Conta(login, senha);
		for(int i = 0; i < this.repositorioConta.getContas().size(); i++){
			if(this.repositorioConta.getContas().get(i).equals(conta)){
				return true;
			}
		}
		return false;
		
	}
	public void adicionarConta(Conta conta){
		this.repositorioConta.adicionar(conta);
	}
	
	public void removerConta(Conta conta){
		this.repositorioConta.remover(conta);
	}
}
