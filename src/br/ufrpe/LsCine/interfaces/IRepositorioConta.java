package br.ufrpe.LsCine.interfaces;

import br.ufrpe.LsCine.negocio.beans.Conta;

public interface IRepositorioConta {

	public boolean adicionar(Conta conta);
	
	public Conta buscarLogin(String nome);
	
	public Conta buscarSenha(String nome);
	
	public boolean remover(String login);
	
	public boolean logar(Conta login);
	
	public void listar();
}
