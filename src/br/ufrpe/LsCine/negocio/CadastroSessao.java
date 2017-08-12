package br.ufrpe.LsCine.negocio;
import br.ufrpe.LsCine.dados.RepositorioSessao;
import br.ufrpe.LsCine.interfaces.IRepositorioSessao;
import br.ufrpe.LsCine.negocio.beans.Sessao;


public class CadastroSessao {

	private IRepositorioSessao repositorioSessao;
	
	public CadastroSessao(IRepositorioSessao repositorio) {
		this.repositorioSessao = repositorio;
	}
	
	public boolean adicionarSessao(Sessao sessao){
		if (sessao == null) {
			return false;
		}
		
		/*if(sessao.getSala().getTipo().equals("IMAX 3D")){
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
		}*/
		return this.repositorioSessao.adicionar(sessao);
		
	}
	
	public boolean removerSessao(int id){
		if(this.repositorioSessao.procurar(id)!=null){
			return this.repositorioSessao.remover(id);
		}
		return false;
	}
	public boolean conferirHorario(){
		return true;
	}
	
	/*public void buscarPorFilme(String nome){
			if(this.repositorioSessao.buscarNome(nome) != null){
				this.repositorioSessao.listarNome(nome);
			}		
	}
	
	public void buscarPorSala(int sala){
			if(this.repositorioSessao.buscar(sala) != null){
				this.repositorioSessao.listarSala(sala);
			}		
	}		*/
	
	public IRepositorioSessao getRepositorioSessao() {
		return repositorioSessao;
	}

	public void setRepositorioSessao(RepositorioSessao repositorioSessao) {
		this.repositorioSessao = repositorioSessao;
	}
	
	public void listar(){
		this.repositorioSessao.listar();
	}

}
