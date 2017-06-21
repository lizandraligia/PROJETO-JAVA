package br.ufrpe.LsCine.negocio;
import java.util.ArrayList;

import br.ufrpe.LsCine.dados.RepositorioSessao;
import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.negocio.beans.Salas;
import br.ufrpe.LsCine.negocio.beans.Sessao;


public class CadastroSessao {

	private RepositorioSessao repositorior;
	
	public CadastroSessao() {
		this.repositorior = new RepositorioSessao();
	}
	
	public boolean adicionarSessao(Sessao sessao){
		if (sessao == null) {
			//System.out.println("Sessão inválida");
			return false;
		}
		
		if(sessao.getSala().getTipo().equals("IMAX 3D")){
			if(this.repositorior.getLim() == 2) {
				//System.out.println("Sala lotada!");
				return false;
			}
		}
		
		if(sessao.getSala().getTipo().equals("IMAX 2D")){
			if(this.repositorior.getLim() == 2) {
				//System.out.println("Sala lotada!");
				return false;
			}
		}
		
		if(sessao.getSala().getTipo().equals("3D")){
			if(this.repositorior.getLim() == 4) {
				//System.out.println("Sala lotada!");
				return false;
			}
		}
		return this.repositorior.adicionar(sessao);
		
	}
	
	//MUDEI O RETORNO DE void PARA BOOLEAN
	public boolean removerSessao(Sessao sessao){
		if(sessao!=null){
			return this.repositorior.remover(sessao);
		}
		return false;
	}
	public boolean conferirHorario(){
		return true;
	}
	
	public ArrayList<Sessao> buscarPorFilme(Filme filme){
		ArrayList<Sessao> listaPorFilme = new ArrayList<>();
		for(int i = 0; i<this.repositorior.listar().size() ;i++){
			if(this.repositorior.listar().get(i).getFilme().equals(filme)){
				listaPorFilme.add(this.repositorior.listar().get(i));
			}
		}
		return listaPorFilme;
		
	}
	public ArrayList<Sessao> buscarPorSala(Salas sala){
		ArrayList<Sessao> listaPorSala = new ArrayList<>();
		for(int i = 0; i<this.repositorior.listar().size() ;i++){
			if(this.repositorior.listar().get(i).getSala().equals(sala)){
				listaPorSala.add(this.repositorior.listar().get(i));
			}
		}
		return listaPorSala;
		
	}
	
	public RepositorioSessao getRepositorioSessao() {
		return repositorior;
	}

	public void setRepositorioSessao(RepositorioSessao repositorioSessao) {
		this.repositorior = repositorioSessao;
	}

}
