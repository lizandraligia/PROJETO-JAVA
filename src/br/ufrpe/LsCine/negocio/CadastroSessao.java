package br.ufrpe.LsCine.negocio;
import br.ufrpe.LsCine.dados.RepositorioSessao;
import br.ufrpe.LsCine.negocio.beans.Sessao;


public class CadastroSessao {

	private RepositorioSessao repositorior;
	
	public CadastroSessao() {
		this.repositorior = new RepositorioSessao();
	}
	
	public boolean adicionarSessao(Sessao sessao){
		if (sessao == null) {
			return false;
		}
		
		if(sessao.getSala().getTipo().equals("IMAX 3D")){
			if(this.repositorior.getLim() == 2) {
				return false;
			}
		}
		
		if(sessao.getSala().getTipo().equals("IMAX 2D")){
			if(this.repositorior.getLim() == 2) {
				return false;
			}
		}
		
		if(sessao.getSala().getTipo().equals("3D")){
			if(this.repositorior.getLim() == 4) {
				return false;
			}
		}
		return this.repositorior.adicionar(sessao);
		
	}
	
	public boolean removerSessao(int id){
		if(this.repositorior.buscar(id)!=null){
			return this.repositorior.remover(id);
		}
		return false;
	}
	public boolean conferirHorario(){
		return true;
	}
	
	public void buscarPorFilme(String nome){
			if(this.repositorior.buscarNome(nome) != null){
				this.repositorior.listarNome(nome);
			}		
	}
	
	public void buscarPorSala(int sala){
			if(this.repositorior.buscar(sala) != null){
				this.repositorior.listarSala(sala);
			}		
	}		
	
	public RepositorioSessao getRepositorioSessao() {
		return repositorior;
	}

	public void setRepositorioSessao(RepositorioSessao repositorioSessao) {
		this.repositorior = repositorioSessao;
	}
	
	public void listar(){
		this.repositorior.listar();
	}

}
