package br.ufrpe.LsCine.negocio;
import br.ufrpe.LsCine.negocio.beans.Conta;
import java.util.ArrayList;
import br.ufrpe.LsCine.dados.RepositorioConta;


public class CadastroConta {

private RepositorioConta repositorioConta;
	
	public CadastroConta(){
		this.repositorioConta = new RepositorioConta();
	}
	
	public boolean logar(Conta login){
		return this.repositorioConta.logar(login);		
	}
	
	public void adicionarConta(Conta conta){
		this.repositorioConta.adicionar(conta);
	}
	
	public void removerConta(String login){
		this.repositorioConta.remover(login);
	}
	
	public void listaContas(){
		this.repositorioConta.listar();
	}
}
