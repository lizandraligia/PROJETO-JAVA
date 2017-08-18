package br.ufrpe.LsCine.negocio;

import br.ufrpe.LsCine.dados.RepositorioIngresso;
import br.ufrpe.LsCine.interfaces.IRepositorioIngresso;
import br.ufrpe.LsCine.negocio.beans.Ingresso;
import java.util.ArrayList;

public class CadastroIngresso {

	private IRepositorioIngresso repositorioI;
	
	public CadastroIngresso(){
		this.repositorioI = RepositorioIngresso.getInstance();
	}

	public IRepositorioIngresso getRepositorioI() {
		return repositorioI;
	}

	public void setRepositorioI(IRepositorioIngresso repositorioI) {
		this.repositorioI = repositorioI;
	}

	public boolean cadastrar(Ingresso ingresso){		
		if(ingresso!=null){
			return this.repositorioI.inserir(ingresso);
		}
		return false;
	}
	
	public boolean remover(int id){
		this.repositorioI.remover(id);
		return true;
	}
	
	public float totalFinanceiro(){
		return this.repositorioI.financeiroIngresso();
	}
	
	public ArrayList<Ingresso> listar(){
		return this.repositorioI.listaVendas();
		
	}
}
