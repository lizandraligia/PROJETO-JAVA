package br.ufrpe.LsCine.negocio;

import java.util.ArrayList;
import br.ufrpe.LsCine.interfaces.IRepositorioFilme;
import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.dados.RepositorioFilme;
import br.ufrpe.LsCine.exceptions.FilmeExistenteException;

public class CadastroFilme {

	private IRepositorioFilme repositorioF;
	
	public CadastroFilme(){
		this.repositorioF = RepositorioFilme.getInstance(); 
	}
	
	public IRepositorioFilme getRepositorioF() {
		return repositorioF;
	}

	public void setRepositorioF(IRepositorioFilme repositorioF) {
		this.repositorioF = repositorioF;
	}

	public boolean cadastrar(Filme filme) throws FilmeExistenteException{
		
		Filme filmeExiste = this.repositorioF.buscarFilme(filme.getNome());
		if(filmeExiste != null){
			throw new FilmeExistenteException();
		}
		
		if(this.repositorioF.inserirFilme(filme)==true){
			if(filme!=null){
				return true;
			}
		}
		return false;
	}
	
	public Filme buscar(String nome){
		return this.repositorioF.buscarFilme(nome);
	}
	
	public boolean remover(String nome){
		if(nome!=null){
			return this.repositorioF.removerFilme(nome);
		}
		return false;
	}
	
	public boolean editar(Filme filme){
		if(this.repositorioF.editarFilme(filme)==true){
			if(filme!=null){
				this.repositorioF.editarFilme(filme);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Filme> listar(){
		return this.repositorioF.listar();
	}
}
