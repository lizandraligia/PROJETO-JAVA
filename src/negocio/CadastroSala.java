package src.br.ufrpe.LsCine.repositorios;
import src.br.ufrpe.LsCine.beans.Salas;

public class CadastroSala {
	
private RepositorioSalas repositorioSalas;
	
	public CadastroSala() {
		this.repositorioSalas = new RepositorioSalas(200);
	}
	public void adicionarSala(Salas sala){
		boolean adicionar = this.repositorioSalas.adicionar(sala);
		if(adicionar){
			System.out.println("Adicionado com sucesso!");
		}
		else{
			System.out.println("Não foi possível adicionar a sala.");
		}
		
	}
	public void remover(Salas sala){
		boolean remover = this.repositorioSalas.remover(sala.getNumero());
		if(remover){
			System.out.println("Removido com sucesso!");
		}
		else{
			System.out.println("Não foi possível remover a sala.");
		}
		
	}
	public Salas procurarId(int idSala){
		return this.repositorioSalas.buscar(idSala);		
	}
	
	public String procurarTipo(int idSala){
		return this.repositorioSalas.buscar(idSala).getTipo();
	} 
	
	public void editarSala(Salas sala){
		this.repositorioSalas.alterar(sala);
	}
	public RepositorioSalas getRepositorioSalas() {		
		return this.repositorioSalas;
	}

}
