package br.ufrpe.LsCine.negocio;
import br.ufrpe.LsCine.dados.RepositorioSalas;
import br.ufrpe.LsCine.negocio.beans.Salas;

public class CadastroSalas {
	
	private RepositorioSalas repositorioSalas;
	
	public CadastroSalas() {
		this.repositorioSalas = new RepositorioSalas(200);
	}
	
	public boolean adicionar(Salas sala){
		if (sala == null) {
			return false;
		}
		if(repositorioSalas.getLim() == repositorioSalas.getSala().length){
			return false;
		}
		if(!this.repositorioSalas.existe(sala.getNumero())){
			return false;
		}
		return this.repositorioSalas.adicionar(sala);
	}
		
	public boolean remover(Salas sala){
		if(sala!=null){
			return this.repositorioSalas.remover(sala.getNumero());
		}
		return false;
	}
	
	public Salas procurarId(int idSala){
		return this.repositorioSalas.buscar(idSala);		
	}
	
	public String procurarTipo(int idSala){
		return this.repositorioSalas.buscar(idSala).getTipo();
	} 
	
	public boolean editar(Salas sala){
		if (sala == null) {
			return false;
		}
		return this.repositorioSalas.alterar(sala);
	}
	
	public RepositorioSalas getRepositorioSalas() {		
		return this.repositorioSalas;
	}

}
