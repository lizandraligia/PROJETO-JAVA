package br.ufrpe.LsCine.dados;
import br.ufrpe.LsCine.negocio.beans.Conta;

public class RepositorioConta {

	private Conta[] contas;
	private int lim;
	
	public RepositorioConta(){
		Conta user = new Conta("admin","admin");
		this.contas = new Conta[10];
		this.contas[0] = user;
		this.lim = 1;
	}
	
	
	public Conta[] getContas() {
		return contas;
	}


	public boolean adicionar(Conta conta){
		this.contas[this.lim]=conta;
		this.lim++;
		return true;

	}
	
	public boolean existe(String login) {
		return this.retornarPosicaoLogin(login)==-1;
	}
	
	public Conta buscarLogin(String nome) {		
		int posicao = this.retornarPosicaoLogin(nome);		
		return (posicao != -1) ? this.contas[posicao] : null;
	}
	
	private int retornarPosicaoLogin(String nome) {		
		for (int i = 0; i< this.lim; i++){
			String cod = contas[i].getLogin();
			if (cod.equals(nome)) {
				return i;
			} 
		}
		
		return -1;
	}
	
	public Conta buscarSenha(String nome) {		
		int posicao = this.retornarPosicaoSenha(nome);		
		return (posicao != -1) ? this.contas[posicao] : null;
	}
	
	private int retornarPosicaoSenha(String nome) {		
		for (int i = 0; i< this.lim; i++){
			String cod = contas[i].getSenha();
			if (cod.equals(nome)) {
				return i;
			} 
		}
		
		return -1;
	}
	
	public boolean remover(String login) {
		int ContaRemover = this.retornarPosicaoLogin(login);
		
		if (ContaRemover == -1) {
			return false;
		}
		
		this.contas[ContaRemover] = this.contas[this.lim -1];
		this.contas[this.lim - 1] = null;
		this.lim = this.lim - 1;
		return true;
		
	}
	
	public boolean alterar(Conta conta) {		
		int contaalterar = this.retornarPosicaoLogin(conta.getLogin());
		if (contaalterar == -1) {
			return false;
		}
		this.contas[contaalterar] = conta;
		return true;
	}
	
	public void listar() {
		for(int i = 0; i<lim; i++){
			System.out.println(contas[i].toString());
			System.out.println();			
		}
	}
	
	public boolean logar(Conta login){
		String log = login.getLogin();
		String sen = login.getSenha();
		for(int i=0; i<10; i++){
			if(this.buscarLogin(log)!= null){
				if(this.buscarSenha(sen)!= null){
					return true;
				}
			}
		}
		return false;
	}
	
}
