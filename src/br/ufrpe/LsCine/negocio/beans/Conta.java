package br.ufrpe.LsCine.negocio.beans;

import java.io.Serializable;

public class Conta implements Serializable {
	
	private String login;
	private String senha;
	
	public Conta()
	{
		}
	public Conta(String login, String senha)
	{
		this.login = login;
		this.senha  = senha;
	}
	
	public String getLogin() {
		return login;
	}
		
	public String getSenha() {
		return senha;
	}
	
	public boolean equals(Conta conta){
		if(this.login.equals(conta.login)){
			if(this.senha.equals(conta.senha)){
				return true;
			}
		}
		return false;
	}
}
