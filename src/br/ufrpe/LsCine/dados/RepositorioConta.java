package br.ufrpe.LsCine.dados;

import br.ufrpe.LsCine.negocio.beans.Conta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import br.ufrpe.LsCine.interfaces.IRepositorioConta;

public class RepositorioConta implements IRepositorioConta, Serializable{

	private ArrayList<Conta> contas;
	private static IRepositorioConta instancia;
	
	public static synchronized IRepositorioConta getInstance(){
		if(instancia == null){
			instancia = lerArquivo();
		}
		return instancia;
	}
	
	public RepositorioConta(){
		Conta user = new Conta("admin","admin");
		this.contas = new ArrayList<Conta>();
		this.contas.add(user);
	}
	
	public static RepositorioConta lerArquivo() {
		RepositorioConta instancia = null;
		File in = new File("Contas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioConta) o;
            
        } catch (Exception e) {
            instancia = new RepositorioConta();
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
		File out = new File("Contas.dat");
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

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	public boolean adicionar(Conta conta){
		this.contas.add(conta);
		this.salvarArquivo();
		return true;

	}
	
	public Conta buscar(Conta conta){
		if(conta == null){
			return null;
		}
		for (int i = 0; i<contas.size() ; i++){	
			if(conta.equals(contas.get(i).getLogin())){
				if(conta.equals(contas.get(i).getSenha())){
				return contas.get(i);
				}
			}			
		}
		return null;
	}
	
	
	public boolean remover(Conta login) {
		if(login==null){
			return false;
		}
		Conta posicao = this.buscar(login);
		if(posicao != null){
			this.contas.remove(posicao);
			this.salvarArquivo();
			return true;
		}
		return false;	
	}
}
