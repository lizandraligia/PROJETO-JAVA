package src.br.ufrpe.LsCine.repositorios;
import java.util.ArrayList;

import src.br.ufrpe.LsCine.beans.Salas;
import src.br.ufrpe.LsCine.beans.Sess�o;


public class CadastroSess�o {

	private RepositorioSess�es repositorior;
	
	public CadastroSess�o() {
		this.repositorior = new RepositorioSess�es();
	}
	
	public void adicionarSessao(Sess�o sessao){
		this.repositorior.adicionar(sessao);
	}
	public void removerSessao(Sess�o sessao){
		this.repositorior.remover(sessao);
	}
	public boolean conferirHorario(){
		return true;
	}
	public ArrayList<Sess�o> buscarPorFilme(Filme filme){
		ArrayList<Sess�o> listaPorFilme = new ArrayList<>();
		for(int i = 0; i<this.repositorior.listar().size() ;i++){
			if(this.repositorior.listar().get(i).getFilme().equals(filme)){
				listaPorFilme.add(this.repositorior.listar().get(i));
			}
		}
		return listaPorFilme;
		
	}
	public ArrayList<Sess�o> buscarPorSala(Salas sala){
		ArrayList<Sess�o> listaPorSala = new ArrayList<>();
		for(int i = 0; i<this.repositorior.listar().size() ;i++){
			if(this.repositorior.listar().get(i).getSala().equals(sala)){
				listaPorSala.add(this.repositorior.listar().get(i));
			}
		}
		return listaPorSala;
		
	}
	
	public RepositorioSess�es getRepositorioSessao() {
		return repositorior;
	}

	public void setRepositorioSessao(RepositorioSess�es repositorioSessao) {
		this.repositorior = repositorioSessao;
	}

}
