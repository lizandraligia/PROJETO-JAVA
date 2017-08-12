package br.ufrpe.LsCine.dados;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import br.ufrpe.LsCine.interfaces.IRepositorioSessao;
import br.ufrpe.LsCine.negocio.beans.Sessao;

public class RepositorioSessao implements IRepositorioSessao{
	
	public 	ArrayList<Sessao> sessoes;
	private static IRepositorioSessao instancia;
	
	public static synchronized IRepositorioSessao getInstance(){
		if(instancia == null){
			instancia = lerArquivo();
		}
		return instancia;
	}
	
	public RepositorioSessao(){
		this.sessoes = new ArrayList<Sessao>();
	}
	
	public static RepositorioSessao lerArquivo() {
		RepositorioSessao instancia = null;
		File in = new File("Sessoes.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioSessao) o;
            
        } catch (Exception e) {
            instancia = new RepositorioSessao();
        } finally {
            if (ois != null) {
            	try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
                
            }
        }
        return instancia;
        
	}
	
	public void salvarArquivo(){
		File out = new File("Salas.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instancia);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try { 
                	oos.close(); 
                } catch (IOException e) {
                	
                }
            }
        }
	}
	
	public boolean adicionar(Sessao sessao){
			int search = buscar(sessao);
			if(sessao != null && search < 0 && this.retornarPosicao(sessao.getId()) == -1){
				this.sessoes.add(sessao);
				//this.salvarArquivo();
				return true;
			}
			return false;
	}
	
	public int buscar(Sessao sessao){
		return this.sessoes.indexOf(sessao);
	}
	
	public Sessao procurar(int codigo) {		
		int posicao = this.retornarPosicao(codigo);		
		return (posicao != -1) ? this.sessoes.get(codigo) : null; 
	}
	
	private int retornarPosicao(int numero) {		
		for (int i = 0; i< this.sessoes.size(); i++){
			int cod = sessoes.get(i).getId();
			if (numero == cod) {
				return i;
			} 
		}
		
		return -1;
	}
	
	public boolean remover(int numero){
		int SessaoRemover = this.retornarPosicao(numero);
		
		if (SessaoRemover == -1) {
			return false;
		}
		

		this.sessoes.remove(this.sessoes.get(SessaoRemover));
		//this.salvarArquivo();
		return true;


	}
	
	public int getNumerosessoes(){
		return sessoes.size();
	}
	
	public boolean alterar(Sessao sessao){
		int search = buscar(sessao);
		if(sessao != null && search!=-1){
			this.sessoes.set(search, sessao);
			//this.salvarArquivo();
			return true;
		}
		return false;
	}
	
	public ArrayList<Sessao> listar(){
		return this.sessoes;
	}
	/*private Sessao[] sessao;
	private int lim;
	
	
	public RepositorioSessao() {
		this.sessao = new Sessao[100];
		this.lim = 0;
	}
	
	
	public Sessao[] getSessao() {
		return sessao;
	}

	public int getLim() {
		return lim;
	}

	public boolean adicionar(Sessao sessao){		

		if(this.lim < 5) {
			this.sessao[lim] = sessao;
			this.lim++;
			return true;
		}else{
			return false;
		}
	}
	
	public boolean remover(int id){
		int SessaoRemover = this.retornarPosicaoid(id);
		
		if (SessaoRemover == -1) {
			
			return false;
		}
		
		this.sessao[SessaoRemover] = this.sessao[this.lim -1];
		this.sessao[this.lim - 1] = null;
		this.lim = this.lim - 1;
		return true;
	}
	
	public boolean alterar(Sessao sessao){
		int sessaoalterar = this.retornarPosicaoid(sessao.getId());
		if (sessaoalterar == -1) {
			return false;
		}
		this.sessao[sessaoalterar] = sessao;
		return true;
	}
	
	
	public Sessao buscar(int codigo) {		
		int posicao = this.retornarPosicaoid(codigo);		
		return (posicao != -1) ? this.sessao[posicao] : null; 
	}
	
	private int retornarPosicaoid(int numero) {		
		for (int i = 0; i< this.lim; i++){
			int cod = sessao[i].getId();
			if (numero == cod) {
				return i;
			} 
		}
		
		return -1;
	}
	
	public Sessao buscarNome(String nome) {		
		int posicao = this.retornarPosicaoNome(nome);		
		return (posicao != -1) ? this.sessao[posicao] : null; 
	}
	
	private int retornarPosicaoNome(String nome) {		
		for (int i = 0; i< this.lim; i++){
			String cod = sessao[i].getFilme().getNome();
			if (cod.equals(nome)) {
				return i;
			} 
		}
		
		return -1;
	}
	
	
	
	public void listarNome(String nome) {
		for(int i = 0; i<lim; i++){
			if(sessao[i].getFilme().getNome().equals(nome)){			
				System.out.println(sessao[i].toString());
				System.out.println();
			}
		}
	}
	
	public void listarSala(int sala) {
		for(int i = 0; i<lim; i++){
			if(sessao[i].getSala().getNumero() == sala){			
				System.out.println(sessao[i].toString());
				System.out.println();
			}
		}
	}
	
	
	public void listar() {
		for(int i = 0; i<lim; i++){
			System.out.println(sessao[i].toString());
			System.out.println();			
		}
	}*/

}
