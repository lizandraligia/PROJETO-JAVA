package br.ufrpe.LsCine.negocio;
import java.util.ArrayList;

import br.ufrpe.LsCine.dados.RepositorioSessao;
import br.ufrpe.LsCine.interfaces.IRepositorioSessao;
import br.ufrpe.LsCine.negocio.beans.Sessao;


public class CadastroSessao {

	private IRepositorioSessao repositorioSessao;
	
	public CadastroSessao() {
		this.repositorioSessao = RepositorioSessao.getInstance();
	}
	
	public boolean adicionarSessao(Sessao sessao){
		if (sessao == null) {
			return false;
		}
		
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
	
	public void buscarPorFilme(String nome){
			if(this.repositorioSessao.buscarNome(nome) != null){
				this.repositorioSessao.listarNome(nome);
			}		
	}
	
	public Sessao procurarID(int codigo){
			return this.repositorioSessao.procurar(codigo);			
	}
	
	/*public void buscarPorSala(int sala){
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
	
	public ArrayList<Sessao> listar(){
		return this.repositorioSessao.listar();
	}

}
