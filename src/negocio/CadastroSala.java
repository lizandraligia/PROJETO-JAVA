package src.br.ufrpe.LsCine.repositorios;
import src.br.ufrpe.LsCine.beans.Salas;

public class CadastroSala {
	
private RepositorioSalas repositorioSalas;
	
	public CadastroSala() {
		this.repositorioSalas = new RepositorioSalas(200);
	}
	public boolean adicionar(Salas sala){
		return this.repositorioSalas.adicionar(sala);
	}
		
	public boolean remover(Salas sala){
		return this.repositorioSalas.remover(sala.getNumero());
	}
	public Salas procurarId(int idSala){
		return this.repositorioSalas.buscar(idSala);		
	}
	
	public String procurarTipo(int idSala){
		return this.repositorioSalas.buscar(idSala).getTipo();
	} 
	
	public boolean editar(Salas sala){
		return this.repositorioSalas.alterar(sala);
	}
	public RepositorioSalas getRepositorioSalas() {		
		return this.repositorioSalas;
	}

}
