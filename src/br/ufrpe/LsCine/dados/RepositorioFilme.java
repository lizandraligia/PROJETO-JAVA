package br.ufrpe.LsCine.dados;

import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.interfaces.IRepositorioFilme;
import br.ufrpe.LsCine.interfaces.IRepositorioSessao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioFilme implements IRepositorioFilme, Serializable{

	private ArrayList<Filme> filmes;
	private static IRepositorioFilme instancia;
	
	public static synchronized IRepositorioFilme getInstance(){
		if(instancia == null){
			instancia = lerArquivo();
		}
		return instancia;
	}
	
	public RepositorioFilme(){
		this.filmes = new ArrayList<Filme>();
	}
	
	public static RepositorioFilme lerArquivo() {
		RepositorioFilme instancia = null;
		File in = new File("Filmes.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioFilme) o;
            
        } catch (Exception e) {
            instancia = new RepositorioFilme();
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
		File out = new File("Filmes.dat");
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

	public ArrayList<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}

	public boolean inserirFilme(Filme filme){
		this.filmes.add(filme);
		this.salvarArquivo();
		return true;
	}
	
	public Filme buscarFilme(String nome){
		if(nome == null){
			return null;
		}
		for (int i = 0; i<filmes.size() ; i++){	
			if(nome.equals(filmes.get(i).getNome())){
				return filmes.get(i);
			}
		}			
		return null;
	}
	
	public boolean removerFilme(String nome){
		if(nome==null){
			return false;
		}
		Filme posicao = this.buscarFilme(nome);
		if(posicao != null){
			this.filmes.remove(posicao);
			this.salvarArquivo();
			return true;
		}
		return false;
		
	}
	
	public boolean editarFilme(Filme filme){ 
		if(filme==null){
			return false;
		}
		Filme atualizar = this.buscarFilme(filme.getNome());
		this.filmes.set(this.filmes.indexOf(atualizar), filme);
		this.salvarArquivo();
		return true;
	}

	
	public ArrayList<Filme> listar(){
		return this.filmes;
	}
}
