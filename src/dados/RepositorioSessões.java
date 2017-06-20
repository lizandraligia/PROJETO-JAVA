package src.br.ufrpe.LsCine.repositorios;
import src.br.ufrpe.LsCine.beans.Sessão;
import java.util.ArrayList;
import java.util.List;

public class RepositorioSessões {
	
	
	private ArrayList<Sessão> sessao;
	private int lim;
	
	public RepositorioSessões() {
		this.sessao = new ArrayList<Sessão>();
		this.lim = 0;
	}
	
	public void adicionar(Sessão sessao){
		
		System.out.println();
		if (sessao == null) {
			System.out.println("Sessão inválida");
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
			System.out.println("Sessão cadastrada com sucesso!");
			return;
		}else{
			System.out.println("Sala lotada!");
			return;
		}
	}
	
	
	public void remover(Sessão sessao){
		int search = pesquisar(sessao);
		if (search != -1) {
			this.sessao.remove(sessao);
			System.out.println("Sessão excluída.");
			return;
		}
		System.out.println("Sessão não encontrada.");
		
	}
	
	public void alterar(Sessão sessao){
		int search = pesquisar(sessao);
		if (search != -1) {
			this.sessao.set(search, sessao);
			System.out.println("Sessão alterada.");
			return;
		}
		System.out.println("Sessão não encontrada.");
		
	}
	
	public int pesquisar(Sessão sessao){
		return this.sessao.indexOf(sessao);
	}
	
	public List<Sessão> listar() {
		List<Sessão> listaOrdenada = this.sessao;
		return listaOrdenada;
	}

	
	
}
