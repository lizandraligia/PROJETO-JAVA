package br.ufrpe.LsCine.dados;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import br.ufrpe.LsCine.interfaces.IRepositorioSalas;
import br.ufrpe.LsCine.negocio.beans.Salas;

public class RepositorioSalas implements IRepositorioSalas, Serializable{
	
	public 	ArrayList<Salas> salas;
	private static IRepositorioSalas instancia;
	
	public static synchronized IRepositorioSalas getInstance(){
		if(instancia == null){
			instancia = lerArquivo();
		}
		return instancia;
	}
	
	public RepositorioSalas(){
		this.salas = new ArrayList<Salas>();
	}
	
	public static RepositorioSalas lerArquivo() {
		RepositorioSalas instancia = null;
		File in = new File("Salas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioSalas) o;
            
        } catch (Exception e) {
            instancia = new RepositorioSalas();
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
	
	public boolean adicionar(Salas sala){
			int search = buscar(sala);
			if(sala != null && search < 0 && this.retornarPosicao(sala.getNumero()) == -1){
				this.salas.add(sala);
				//this.salvarArquivo();
				return true;
			}
			return false;
	}
	
	public int buscar(Salas sala){
		return this.salas.indexOf(sala);
	}
	
	public Salas procurar(int codigo) {		
		int posicao = this.retornarPosicao(codigo);		
		return (posicao != -1) ? this.salas.get(posicao) : null; 
	}
	
	private int retornarPosicao(int numero) {		
		for (int i = 0; i< this.salas.size(); i++){
			int cod = salas.get(i).getNumero();
			if (numero == cod) {
				return i;
			} 
		}
		
		return -1;
	}
	
	public boolean remover(int numero){
		int SalaRemover = this.retornarPosicao(numero);
		
		if (SalaRemover == -1) {
			return false;
		}
		

		this.salas.remove(this.salas.get(SalaRemover));
		//this.salvarArquivo();
		return true;


	}
	
	public int getNumerosalas(){
		return salas.size();
	}
	
	public boolean alterar(Salas sala){
		int search = buscar(sala);
		if(sala != null && search!=-1){
			this.salas.set(search, sala);
			//this.salvarArquivo();
			return true;
		}
		return false;
	}
	
	public ArrayList<Salas> listar(){
		return this.salas;
	}
	
	/*private Salas[] sala;
	private int lim;
	private final static int QTD_SALAS = 10;
	
	public RepositorioSalas() {
		this.sala = new Salas[QTD_SALAS];
		this.lim = 0;
	}
	
	public Salas[] getSala() {
		return sala;
	}
	public int getLim() {
		return lim;
	}

	public boolean adicionar(Salas sala){

		this.sala[this.lim]=sala;
		this.lim++;
		return true;

	}

	public boolean existe(int numero) {
		return this.retornarPosicao(numero)==-1;
	}
	
	public Salas buscar(int codigo) {		
		int posicao = this.retornarPosicao(codigo);		
		return (posicao != -1) ? this.sala[posicao] : null; 
	}
	
	public boolean remover(int numero) {
		int SalaRemover = this.retornarPosicao(numero);
		
		if (SalaRemover == -1) {
			return false;
		}
		
		this.sala[SalaRemover] = this.sala[this.lim -1];
		this.sala[this.lim - 1] = null;
		this.lim = this.lim - 1;
		return true;
		
	}
	
	public boolean alterar(Salas sala) {		
		int salaalterar = this.retornarPosicao(sala.getNumero());
		if (salaalterar == -1) {
			return false;
		}
		this.sala[salaalterar] = sala;
		return true;
	}
	
	public void listar() {
		for(int i = 0; i<lim; i++){
			System.out.println(sala[i].toString());
			System.out.println();			
		}
	}

	private int retornarPosicao(int numero) {		
		for (int i = 0; i< this.lim; i++){
			int cod = sala[i].getNumero();
			if (numero == cod) {
				return i;
			} 
		}
		
		return -1;
	}
	
	public void mostrar(Salas posicao){
		System.out.println();
		if(posicao != null){
		System.out.println(posicao.toString());
		}		
	}

	public void totalsalas(){
		System.out.println("Existem no momento " + this.lim + " salas cadastradas\nAinda Ã© possÃ­vel cadastrar mais " + (this.sala.length - this.lim));
	}*/

}
