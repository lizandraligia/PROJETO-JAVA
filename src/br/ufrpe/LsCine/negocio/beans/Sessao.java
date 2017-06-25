package br.ufrpe.LsCine.negocio.beans;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sessao {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	private Filme filme;
	private Salas sala;
	private Date hrinicio;
	private Date hrfim;
	private int id;
	private Boolean[] cadeira = new Boolean[200];
	
	
	public Sessao(Filme filme, Salas sala, Date hrinicio, Date hrfim, int id) {

		
		this.filme = filme;
		this.sala = sala;
		this.hrinicio = hrinicio;
		this.hrfim = hrfim;
		this.id = id;
		for(int i = 0; i<200; i++){
			this.cadeira[i] = false;
		}
		
	}	

	public Filme getFilme() {
		//ESSE RETURN TA ERRADO
		//return this.filme.getNome;
		//SE QUISER RETORNAR SO O NOME DO FILME: return filme.getNome(); E MODIFICAR O RETORNO DE Filme PARA String
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Salas getSala() {
		return sala;
	}

	public void setSala(Salas sala) {
		this.sala = sala;
	}

	public String getHrinicio() {
		return sdf.format(this.hrinicio);
	}

	public void setHrinicio(Date hrinicio) {
		this.hrinicio = hrinicio;
	}

	public String getHrfim() {
		return sdf.format(this.hrfim);
	}

	public void setHrfim(Date hrfim) {
		this.hrfim = hrfim;
	}

	public Boolean getCadeira(int i) {
		return cadeira[i];
	}

	public void setCadeira(int i) {
		if(this.cadeira[i] == false){
			this.cadeira[i] = true;
			System.out.println("Compra efetuada.");
		}else{
			System.out.println("Cadeira ocupada.");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {       
		return "Filme: " + this.filme.getNome() + "\nSala: " + this.sala.getNumero() + "\nInicio=" + sdf.format(this.hrinicio) + "\nFim=" + sdf.format(this.hrfim) + "\nId= " + this.id;
	}
	
	public boolean equals(Sessao comparada) {
		if (this.filme.getNome().equals(comparada.filme.getNome())) {
			if (this.hrinicio.equals(comparada.hrinicio)) {
				if (this.sala.equals(comparada.sala)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
