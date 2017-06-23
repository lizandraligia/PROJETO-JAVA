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
	//CRIEI METODOS GET
	public Salas[] getSala() {
		return sala;
	}
	public int getLim() {
		return lim;
	}

	public boolean adicionar(Salas sala){
		
		//int busca = this.retornarPosicao(sala.getNumero());
		//System.out.println();
		/*if (sala == null) {
			System.out.println("Sala inválida");
			return false;
		}
		
		if(this.lim == this.sala.length){
			//System.out.println("Não é possível adicionar mais salas");
			return false;
		}
		
		
		if(busca != -1){
			//System.out.println("Sala já registrada!");
			return false;
		}*/
		

		this.sala[this.lim]=sala;
		this.lim++;
		//System.out.println("Sala cadastrada com sucesso!");
		return true;

	}
	
	//CRIEI METODO EXISTE
	public boolean existe(int numero) {
		return this.retornarPosicao(numero)==-1;
	}
	
	public Salas buscar(int codigo) {		
		int posicao = this.retornarPosicao(codigo);		
		return (posicao != -1) ? this.sala[posicao] : null; 
	}
	
	public boolean remover(int numero) {
		//System.out.println();
		int SalaRemover = this.retornarPosicao(numero);
		
		if (SalaRemover == -1) {
			//System.out.println("Sala não encontrada.");
			return false;
		}
		
		this.sala[SalaRemover] = this.sala[this.lim -1];
		this.sala[this.lim - 1] = null;
		this.lim = this.lim - 1;
		
		//System.out.println("Sala removida com sucesso.");
		return true;
		
	}
	
	public boolean alterar(Salas sala) {
		//System.out.println();
		/*if (sala == null) {
			//System.out.println("Sala inválido!");
			return false;
		}*/
		
		int salaalterar = this.retornarPosicao(sala.getNumero());
		if (salaalterar == -1) {
			//System.out.println("Sala inexistente.");
			return false;
		}
		this.sala[salaalterar] = sala;
		//System.out.println("Sala alterada.");
		return true;
	}
	
	public void listar() {
		//System.out.println();
		//System.out.println("Todos as salas cadastradas são: ");
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
	
	
	//NAO ENTENDI PQ CRIOU ESSE METODO. SE MANTER, TEM QUE REMOVER DO REPOSITORIO E COLOCAR EM OUTRA CLASSE
	public void mostrar(Salas posicao){
		System.out.println();
		if(posicao != null){
		System.out.println(posicao.toString());
		}		
	}
	
	//ESSE METODO NAO DEVE FICAR NO REPOSITORIO. MOVER PRA OUTRA CLASSE
	public void totalsalas(){
		System.out.println("Existem no momento " + this.lim + " salas cadastradas\nAinda é possível cadastrar mais " + (this.sala.length - this.lim));
	}
}
