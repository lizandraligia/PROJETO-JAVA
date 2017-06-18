package negocio.beans;

public class Ingresso {

	private int tipo; //1 - inteira; 2 - meia
	private float valor;
	//Sessao sessao; sessão 2d, 3d, valores
	
	public Ingresso(int tipo, float valor){
		this.tipo = tipo;
		this.valor = valor;
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
		return valor;
	}

	public void setValor(float valor) {
		if(this.tipo==1){
			this.valor = valor;
		}
		if(this.tipo==2){
			this.valor = valor/2;
		}
	}

}
