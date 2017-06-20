package negocio;

import dados.RepositorioFilme;
import negocio.beans.Filme;

public class CadastroFilme {

	private RepositorioFilme repositorioF;
	
	public CadastroFilme(){
		this.repositorioF = new RepositorioFilme();
	}
	
	public RepositorioFilme getRepositorioF() {
		return repositorioF;
	}

	public void setRepositorioF(RepositorioFilme repositorioF) {
		this.repositorioF = repositorioF;
	}

	public boolean cadastrar(Filme filme){
		
		if(this.repositorioF.inserirFilme(filme)==true){
			if(filme!=null && !this.repositorioF.existe(filme.getNome())){
				//this.repositorioF.inserirFilme(filme);
				return true;
			}
		}
		return false;
	}
	
	public Filme buscar(String nome){
		return this.repositorioF.buscarFilme(nome);
	}
	
	public boolean existe(String nome){
		return this.repositorioF.existe(nome);
	}
	
	public boolean remover(String nome){
		if(nome!=null){
			return this.repositorioF.removerFilme(nome);
		}
		return false;
	}
	
	public boolean editar(Filme filme){
		if(this.repositorioF.editarFilme(filme)==true){
			if(filme!=null && !this.repositorioF.existe(filme.getNome())){
				this.repositorioF.editarFilme(filme);
				//this.repositorioF.inserirFilme(filme);
				return true;
			}
		}
		return false;
	}
	
	public void lista(){
		this.repositorioF.listarFilmes();
	}
}
