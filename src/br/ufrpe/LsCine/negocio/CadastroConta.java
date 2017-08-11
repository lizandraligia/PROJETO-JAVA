package br.ufrpe.LsCine.negocio;
import br.ufrpe.LsCine.negocio.beans.Conta;
import java.util.ArrayList;
import br.ufrpe.LsCine.dados.RepositorioConta;
import br.ufrpe.LsCine.interfaces.IRepositorioConta;


public class CadastroConta{

	private IRepositorioConta repositorioConta;
	
	public CadastroConta(IRepositorioConta repositorio){
		this.repositorioConta = repositorio;
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
	
	public boolean adicionarConta(Conta conta){
		return this.repositorioConta.adicionar(conta);
	}
	
	public boolean removerConta(Conta login){
		return this.repositorioConta.remover(login);
	}
}
