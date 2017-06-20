package src.br.ufrpe.LsCine.repositorios;
import java.util.ArrayList;

import src.br.ufrpe.LsCine.beans.Salas;
import src.br.ufrpe.LsCine.beans.Sessão;


public class CadastroSessão {

	private RepositorioSessões repositorior;
	
	public CadastroSessão() {
		this.repositorior = new RepositorioSessões();
	}
	
	public void adicionarSessao(Sessão sessao){
		this.repositorior.adicionar(sessao);
	}
	public void removerSessao(Sessão sessao){
		this.repositorior.remover(sessao);
	}
	public boolean conferirHorario(){
		return true;
	}
	public ArrayList<Sessão> buscarPorFilme(Filme filme){
		ArrayList<Sessão> listaPorFilme = new ArrayList<>();
		for(int i = 0; i<this.repositorior.listar().size() ;i++){
			if(this.repositorior.listar().get(i).getFilme().equals(filme)){
				listaPorFilme.add(this.repositorior.listar().get(i));
			}
		}
		return listaPorFilme;
		
	}
	public ArrayList<Sessão> buscarPorSala(Salas sala){
		ArrayList<Sessão> listaPorSala = new ArrayList<>();
		for(int i = 0; i<this.repositorior.listar().size() ;i++){
			if(this.repositorior.listar().get(i).getSala().equals(sala)){
				listaPorSala.add(this.repositorior.listar().get(i));
			}
		}
		return listaPorSala;
		
	}
	
	public RepositorioSessões getRepositorioSessao() {
		return repositorior;
	}

	public void setRepositorioSessao(RepositorioSessões repositorioSessao) {
		this.repositorior = repositorioSessao;
	}

}
