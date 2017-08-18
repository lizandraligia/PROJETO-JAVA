package br.ufrpe.LsCine.dados;

import br.ufrpe.LsCine.negocio.beans.Ingresso;
import br.ufrpe.LsCine.interfaces.IRepositorioIngresso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioIngresso implements IRepositorioIngresso, Serializable{
	
	private ArrayList<Ingresso> ingressos;
	private static IRepositorioIngresso instancia;
	
	public static synchronized IRepositorioIngresso getInstance(){
		if(instancia == null){
			instancia = lerArquivo();
		}
		return instancia;
	}
	
	public RepositorioIngresso(){
		this.ingressos = new ArrayList<Ingresso>();
	}
	
	public static RepositorioIngresso lerArquivo() {
		RepositorioIngresso instancia = null;
		File in = new File("Ingressos.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioIngresso) o;
            
        } catch (Exception e) {
            instancia = new RepositorioIngresso();
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
		File out = new File("Ingressos.dat");
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

	public ArrayList<Ingresso> getIngresso() {
		return ingressos;
	}
	
	public void setIngresso(ArrayList<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public boolean inserir(Ingresso ingresso){	
		this.ingressos.add(ingresso);
		this.salvarArquivo();
		return true;
	}

	public Ingresso buscar(int id){
		if(id<0){
			return null;
		}
		for (int i = 0; i < ingressos.size() ; i++){	
			if(id==ingressos.get(i).getId()){
				return ingressos.get(i);
			}
		}			
		return null;
	}
	
	public boolean remover(int id){
		if(id<0){
			return false;
		}
		Ingresso posicao = this.buscar(id);
		if(posicao != null){
			this.ingressos.remove(posicao);
			this.salvarArquivo();
			return true;
		}
		return false;
	}
	
	public ArrayList<Ingresso> listaVendas(){
		return this.ingressos;
	}
	
	public float financeiroIngresso(){
		float valor = 0;
		for (int i = 0; i<ingressos.size(); i++){
			valor+=this.ingressos.get(i).getValor();
		}
		return valor;
	}
}
