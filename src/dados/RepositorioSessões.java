package src.br.ufrpe.LsCine.repositorios;
import src.br.ufrpe.LsCine.beans.Sess�o;
import java.util.ArrayList;
import java.util.List;

public class RepositorioSess�es {
	
	
	private ArrayList<Sess�o> sessao;
	private int lim;
	
	public RepositorioSess�es() {
		this.sessao = new ArrayList<Sess�o>();
		this.lim = 0;
	}
	
	public void adicionar(Sess�o sessao){
		
		System.out.println();
		if (sessao == null) {
			System.out.println("Sess�o inv�lida");
			return;
		}
		
		if(sessao.getSala().getTipo().equals("IMAX 3D")){
			if(this.lim == 2) {
				System.out.println("Sala lotada!");
				return;
			}
		}
		
		if(sessao.getSala().getTipo().equals("IMAX 2D")){
			if(this.lim == 2) {
				System.out.println("Sala lotada!");
				return;
			}
		}
		
		if(sessao.getSala().getTipo().equals("3D")){
			if(this.lim == 4) {
				System.out.println("Sala lotada!");
				return;
			}
		}
		

		if(this.lim < 5) {
			this.sessao.add(sessao);
			this.lim++;
			System.out.println("Sess�o cadastrada com sucesso!");
			return;
		}else{
			System.out.println("Sala lotada!");
			return;
		}
	}
	
	
	public void remover(Sess�o sessao){
		int search = pesquisar(sessao);
		if (search != -1) {
			this.sessao.remove(sessao);
			System.out.println("Sess�o exclu�da.");
			return;
		}
		System.out.println("Sess�o n�o encontrada.");
		
	}
	
	public void alterar(Sess�o sessao){
		int search = pesquisar(sessao);
		if (search != -1) {
			this.sessao.set(search, sessao);
			System.out.println("Sess�o alterada.");
			return;
		}
		System.out.println("Sess�o n�o encontrada.");
		
	}
	
	public int pesquisar(Sess�o sessao){
		return this.sessao.indexOf(sessao);
	}
	
	public List<Sess�o> listar() {
		List<Sess�o> listaOrdenada = this.sessao;
		return listaOrdenada;
	}

	
	
}
