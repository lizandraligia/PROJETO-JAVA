package src.br.ufrpe.LsCine.beans;

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
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
		
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean equals(Conta conta){
		if(login.equals(conta.login)){
			if(senha.equals(conta.senha)){
				return true;
			}
		}
		return false;
	}
}
