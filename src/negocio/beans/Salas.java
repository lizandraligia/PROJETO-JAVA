package src.br.ufrpe.LsCine.beans;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;

public class Salas {
	
	private int numero;
	private boolean s3d;
	private boolean imax;
	private String tipo;
	
	public Salas(int numero, boolean s3d, boolean imax) {
		this.numero = numero;
		this.s3d = s3d;
		this.imax = imax;
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
		//return this.tipo;
		if(this.s3d == true && this.imax == true){
			return "IMAX 3D";
		}else if(this.s3d == true && this.imax != true){
			return "3D";
		}else if(this.s3d != true && this.imax == true){
			return "IMAX 2D";
		}else if(this.s3d != true && this.imax != true){
			return "Normal";
		}
		return "nao disponivel";
	}
	
	public void setTipo() {
		/*if(this.s3d == true && this.imax == true){
			this.tipo = "IMAX 3D";
		}else if(this.s3d == true && this.imax != true){
			this.tipo = "3D";
		}else if(this.s3d != true && this.imax == true){
			this.tipo = "IMAX 2D";
		}else if(this.s3d != true && this.imax != true){
			this.tipo = "Normal";
		}*/
		this.tipo = tipo;
		
	}
	

	public String toString() {
		return "Sala " + this.numero + "\ntipo= " + getTipo(); //this.tipo;
	}
	
	
	
	

}
