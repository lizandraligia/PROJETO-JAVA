package negocio.beans;

public class Ingresso {

	private int tipo; 
	private float valor;
	private Sessão sessao; 
	private int id;
	
	public Ingresso(int tipo, float valor, Sessão sessao){
		this.tipo = tipo;
		this.valor = valor;
		this.sessao = sessao;
		//this.id = id;
	}
	
	public Ingresso(){
		
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
		
	}

	public float getValor() {
		if(this.tipo==1){
			return valor;
		}
		if(this.tipo==2){
			return (valor/2);
		}
		return -1;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Sessão getSessao() {
		return sessao;
	}

	public void setSessao(Sessão sessao) {
		this.sessao = sessao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
