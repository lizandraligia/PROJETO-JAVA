package br.ufrpe.LsCine.negocio.beans;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sessao implements Serializable{
	
	public Sessao() {
		super();
	}

	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	private Filme filme;
	private Salas sala;
	private Date hrinicio;
	private Date hrfim;
	private int id;
	private boolean[] cadeira = new boolean[200];
	private boolean leg;
	
	
	
	
	public Sessao(Filme filme, Salas sala, Date hrinicio, Date hrfim, int id, boolean leg) {
	
		this.filme = filme;
		this.sala = sala;
		this.hrinicio = hrinicio;
		this.hrfim = hrfim;
		this.id = id;
		this.setLeg(leg);
		for(int i = 0; i<200; i++){
			this.cadeira[i] = false;
		}
		
	}
	

	public Filme getFilme() {
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

	public boolean setCadeira(int i) {
		if(this.cadeira[i] == false){
			this.cadeira[i] = true;
			return true;
		}else{
			return false;
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


	public boolean isLeg() {
		return leg;
	}


	public void setLeg(boolean leg) {
		this.leg = leg;
	}
	
}
