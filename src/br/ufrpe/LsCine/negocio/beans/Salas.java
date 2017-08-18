package br.ufrpe.LsCine.negocio.beans;

import java.io.Serializable;

public class Salas implements Serializable{
	
	private int numero;
	private boolean s3d;
	private boolean imax;
	private String tipo;
	
	public Salas(int numero, boolean s3d, boolean imax) {
		this.numero = numero;
		this.s3d = s3d;
		this.imax = imax;
		
		if(this.s3d == true && this.imax == true){
			this.tipo = "IMAX 3D";
		}else if(this.s3d == true && this.imax != true){
			this.tipo = "3D";
		}else if(this.s3d != true && this.imax == true){
			this.tipo = "IMAX 2D";
		}else if(this.s3d != true && this.imax != true){
			this.tipo = "Normal";
		}
		
	}
	
	public Salas() {
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		if(numero <= 0){
			System.out.println("Numeração inválida.");		
		}else{
			this.numero = numero;
		}
	}
	
	public boolean isS3d() {
		return s3d;
	}
	
	public void setS3d(boolean s3d) {
		this.s3d = s3d;
	}
	
	public boolean isImax() {
		return imax;
	}
	
	public void setImax(boolean imax) {
		this.imax = imax;
	}
	
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "\tSala " + this.numero + "\n\tTipo= " + this.getTipo();
	}

}
