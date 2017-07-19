package br.ufrpe.LsCine.dados;
import br.ufrpe.LsCine.negocio.beans.Salas;

public class RepositorioSalas {
	private Salas[] sala;
	private int lim;
	private final static int QTD_SALAS = 10;
	
	public RepositorioSalas() {
		this.sala = new Salas[QTD_SALAS];
		this.lim = 0;
	}
	
	public Salas[] getSala() {
		return sala;
	}
	public int getLim() {
		return lim;
	}

	public boolean adicionar(Salas sala){

		this.sala[this.lim]=sala;
		this.lim++;
		return true;

	}

	public boolean existe(int numero) {
		return this.retornarPosicao(numero)==-1;
	}
	
	public Salas buscar(int codigo) {		
		int posicao = this.retornarPosicao(codigo);		
		return (posicao != -1) ? this.sala[posicao] : null; 
	}
	
	public boolean remover(int numero) {
		int SalaRemover = this.retornarPosicao(numero);
		
		if (SalaRemover == -1) {
			return false;
		}
		
		this.sala[SalaRemover] = this.sala[this.lim -1];
		this.sala[this.lim - 1] = null;
		this.lim = this.lim - 1;
		return true;
		
	}
	
	public boolean alterar(Salas sala) {		
		int salaalterar = this.retornarPosicao(sala.getNumero());
		if (salaalterar == -1) {
			return false;
		}
		this.sala[salaalterar] = sala;
		return true;
	}
	
	public void listar() {
		for(int i = 0; i<lim; i++){
			System.out.println(sala[i].toString());
			System.out.println();			
		}
	}

	private int retornarPosicao(int numero) {		
		for (int i = 0; i< this.lim; i++){
			int cod = sala[i].getNumero();
			if (numero == cod) {
				return i;
			} 
		}
		
		return -1;
	}
	
	public void mostrar(Salas posicao){
		System.out.println();
		if(posicao != null){
		System.out.println(posicao.toString());
		}		
	}

	public void totalsalas(){
		System.out.println("Existem no momento " + this.lim + " salas cadastradas\nAinda é possível cadastrar mais " + (this.sala.length - this.lim));
	}
}
