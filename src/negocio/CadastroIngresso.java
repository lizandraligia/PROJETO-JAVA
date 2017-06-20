package negocio;

import dados.RepositorioIngresso;
import negocio.beans.Ingresso;

public class CadastroIngresso {

	private RepositorioIngresso repositorioI;
	
	public CadastroIngresso(){
		this.repositorioI = new RepositorioIngresso();
	}

	public RepositorioIngresso getRepositorioI() {
		return repositorioI;
	}

	public void setRepositorioI(RepositorioIngresso repositorioI) {
		this.repositorioI = repositorioI;
	}

	public boolean cadastrar(Ingresso ingresso){
		
		if(this.repositorioI.inserir(ingresso)==true){
			return true;
		}
		return false;
	}
	
	public boolean remover(int id){
		if(this.repositorioI.remover(id)){
			return true;
		}
		return false;
	}
	
	public float totalFinanceiro(){
		return this.repositorioI.financeiroIngresso();
	}
	
}
