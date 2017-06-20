package src.br.ufrpe.LsCine.repositorios;
import java.util.ArrayList;

import src.br.ufrpe.LsCine.beans.Salas;
import src.br.ufrpe.LsCine.beans.Sessão;


public class CadastroSessão {

	private RepositorioSessões repositorior;
	
	public CadastroSessão() {
		this.repositorior = new RepositorioSessões();
	}
	
	//MUDEI O RETORNO DE void PARA BOOLEAN
	public boolean adicionarSessao(Sessão sessao){
		//PEGUEI AS VALIDACOES QUE TU TINHA COLOCADO NO REPOSITORIO 
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
	public boolean removerSessao(Sessão sessao){
		if(sessao!=null){
			return this.repositorior.remover(sessao);
		}
		return false;
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
