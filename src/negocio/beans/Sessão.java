package src.br.ufrpe.LsCine.beans;
import java.text.SimpleDateFormat;
//import java.util.Arrays;
import java.util.Date;

public class Sessão {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
	private Filme filme;
	private Salas sala;
	private Date hrinicio;
	private Date hrfim;
	private Boolean[] cadeira = new Boolean[200];
	//A VARIAVEL VALOR JA ESTA NA CLASSE INGRESSO. REMOVER DAQUI.
	float valor;
	
	public Sessão(Filme filme, Salas sala, Date hrinicio, float valor) {
		//NAO ESTAMOS USANDO HERANÇA, PRA QUE ESSE SUPER() ?
		//super();
		this.filme = filme;
		this.sala = sala;
		this.hrinicio = hrinicio;
		//this.hrfim = this.hrinicio + filme.getDuração();
		//CONFERIR SE O Set hrfim FUNCIONA
		this.hrfim.setMinutes(this.hrinicio.getMinutes() + this.filme.getDuracao());
		this.valor = valor;
		
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

	//MUDEI RETORNO DE Date PARA String
	public String getHrinicio() {
		return sdf.format(this.hrinicio);
	}

	public void setHrinicio(Date hrinicio) {
		this.hrinicio = hrinicio;
	}
	//MUDEI RETORNO DE Date PARA String
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String toString() {
		return "Filme: " + this.filme.getNome() +"\nInicio=" + sdf.format(this.hrinicio) + "\nFim=" + sdf.format(this.hrfim) + "\nValor=" + valor;
	}
	
	public boolean equals(Sessão comparada) {
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
