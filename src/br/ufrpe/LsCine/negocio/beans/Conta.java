package br.ufrpe.LsCine.negocio.beans;

public class Conta {
	
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

	public void setLogin(String login) {
		this.login = login;
	}
		
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean equals(Conta conta){
		if(this.login.equals(conta.login)){
			if(this.senha.equals(conta.senha)){
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return "Conta [login=" + login + ", senha=" + senha + "]";
	}

}
