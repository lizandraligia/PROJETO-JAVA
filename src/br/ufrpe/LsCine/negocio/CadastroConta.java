package br.ufrpe.LsCine.negocio;
import br.ufrpe.LsCine.negocio.beans.Conta;
import br.ufrpe.LsCine.dados.RepositorioConta;
import br.ufrpe.LsCine.interfaces.IRepositorioConta;
import br.ufrpe.LsCine.exceptions.LoginIncorretoException;


public class CadastroConta{

	private IRepositorioConta repositorioConta;
	
	public CadastroConta(){
		this.repositorioConta = RepositorioConta.getInstance();
	}
	
	public boolean logar(String login, String senha) throws LoginIncorretoException{
		Conta conta = new Conta(login, senha);
		
		for(int i = 0; i < this.repositorioConta.getContas().size(); i++){
			if(this.repositorioConta.getContas().get(i).equals(conta)){
				return true;
			}
		}	
		throw new LoginIncorretoException();
	}
	
	public boolean adicionarConta(Conta conta){
		return this.repositorioConta.adicionar(conta);
	}
	
	public boolean removerConta(Conta login){
		return this.repositorioConta.remover(login);
	}
}
