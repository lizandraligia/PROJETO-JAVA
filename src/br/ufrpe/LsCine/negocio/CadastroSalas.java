package br.ufrpe.LsCine.negocio;
import java.util.ArrayList;

import br.ufrpe.LsCine.dados.RepositorioSalas;
import br.ufrpe.LsCine.interfaces.IRepositorioFilme;
import br.ufrpe.LsCine.interfaces.IRepositorioSalas;
import br.ufrpe.LsCine.negocio.beans.Salas;

public class CadastroSalas {
	
	private IRepositorioSalas repositorioSalas;
	
	public CadastroSalas(IRepositorioSalas repositorio) {
		this.repositorioSalas = repositorio;
	}
	
	public boolean adicionar(Salas sala){
		if (sala == null) {
			return false;
		}
		return this.repositorioSalas.adicionar(sala);
	}
		
	public boolean remover(int idSala){
		if(this.repositorioSalas.procurar(idSala) != null){
				return this.repositorioSalas.remover(idSala);
		}
		return false;
	}
	
	public Salas procurarId(int idSala){
		return this.repositorioSalas.procurar(idSala);		
	}
	
	public String procurarTipo(int idSala){
		return this.repositorioSalas.procurar(idSala).getTipo();
	} 
	
	public boolean editar(Salas sala){
		if (sala == null) {
			return false;
		}
		return this.repositorioSalas.alterar(sala);
	}
	
	public IRepositorioSalas getRepositorioSalas() {		
		return this.repositorioSalas;
	}
	
	public ArrayList<Salas> listar(){
		return this.repositorioSalas.listar();
	}

}
