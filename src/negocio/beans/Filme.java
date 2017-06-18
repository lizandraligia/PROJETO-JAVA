package negocio.beans;

public class Filme {

	private String nome;
	private int duracao; 
	private int classificacao; //if 1 == livre, if 2 == +12
	
	public Filme(String nome, int duracao, int classificacao){
		this.nome = nome;
		this.duracao = duracao;
		this.classificacao = classificacao;
	}
	
	public Filme(){
		
	}
	
	public String toString() {
		return "Filme [Nome: " + nome + ", duracao: " + duracao + ", classificacao " + classificacao + "]";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public int getClassificacao() {
		return classificacao;
	}
	
	public void setClassificacao(int classificacao) {
		if(classificacao==1){
			System.out.println("LIVRE");
		}
		if(classificacao==2){
			System.out.println("+10");
		}
		if(classificacao==3){
			System.out.println("+12");
		}
		if(classificacao==4){
			System.out.println("+14");
		}
		if(classificacao==5){
			System.out.println("+16");
		}
		if(classificacao==6){
			System.out.println("+18");
		}
	}

}
