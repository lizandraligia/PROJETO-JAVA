package br.ufrpe.LsCine.dados;
import br.ufrpe.LsCine.negocio.beans.Sessao;

public class RepositorioSessao {
	
	private Sessao[] sessao;
	private int lim;
	
	
	public RepositorioSessao() {
		this.sessao = new Sessao[100];
		this.lim = 0;
	}
	
	
	public Sessao[] getSessao() {
		return sessao;
	}

	public int getLim() {
		return lim;
	}

	public boolean adicionar(Sessao sessao){		

		if(this.lim < 5) {
			this.sessao[lim] = sessao;
			this.lim++;
			return true;
		}else{
			return false;
		}
	}
	
	public boolean remover(int id){
		int SessaoRemover = this.retornarPosicaoid(id);
		
		if (SessaoRemover == -1) {
			
			return false;
		}
		
		this.sessao[SessaoRemover] = this.sessao[this.lim -1];
		this.sessao[this.lim - 1] = null;
		this.lim = this.lim - 1;
		return true;
	}
	
	public boolean alterar(Sessao sessao){
		int sessaoalterar = this.retornarPosicaoid(sessao.getId());
		if (sessaoalterar == -1) {
			return false;
		}
		this.sessao[sessaoalterar] = sessao;
		return true;
	}
	
	
	public Sessao buscar(int codigo) {		
		int posicao = this.retornarPosicaoid(codigo);		
		return (posicao != -1) ? this.sessao[posicao] : null; 
	}
	
	private int retornarPosicaoid(int numero) {		
		for (int i = 0; i< this.lim; i++){
			int cod = sessao[i].getId();
			if (numero == cod) {
				return i;
			} 
		}
		
		return -1;
	}
	
	public Sessao buscarNome(String nome) {		
		int posicao = this.retornarPosicaoNome(nome);		
		return (posicao != -1) ? this.sessao[posicao] : null; 
	}
	
	private int retornarPosicaoNome(String nome) {		
		for (int i = 0; i< this.lim; i++){
			String cod = sessao[i].getFilme().getNome();
			if (cod.equals(nome)) {
				return i;
			} 
		}
		
		return -1;
	}
	
	
	
	public void listarNome(String nome) {
		for(int i = 0; i<lim; i++){
			if(sessao[i].getFilme().getNome().equals(nome)){			
				System.out.println(sessao[i].toString());
				System.out.println();
			}
		}
	}
	
	public void listarSala(int sala) {
		for(int i = 0; i<lim; i++){
			if(sessao[i].getSala().getNumero() == sala){			
				System.out.println(sessao[i].toString());
				System.out.println();
			}
		}
	}
	
	
	public void listar() {
		for(int i = 0; i<lim; i++){
			System.out.println(sessao[i].toString());
			System.out.println();			
		}
	}

}
