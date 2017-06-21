package br.ufrpe.LsCine.negocio;

import java.util.ArrayList;

import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.negocio.beans.Ingresso;
import br.ufrpe.LsCine.negocio.beans.Salas;
import br.ufrpe.LsCine.negocio.beans.Sessao;

public class Fachada {

	private CadastroFilme cadastroF;
	private CadastroIngresso cadastroI;
	private CadastroSalas cadastroSa;
	private CadastroSessao cadastroSe;
	
	public Fachada(){
		this.cadastroF = new CadastroFilme();
		this.cadastroI = new CadastroIngresso();
		this.cadastroSa = new CadastroSalas();
		this.cadastroSe = new CadastroSessao();
	}
	
	//FILME 
	
	public boolean cadastrarFilme(Filme filme){
		return this.cadastroF.cadastrar(filme);
	}
	
	public Filme buscarFilme(String nome){
		return this.cadastroF.buscar(nome);
	}
	
	public boolean existeFilme(String nome){
		return this.cadastroF.existe(nome);
	}
	
	public boolean removerFilme(String nome){
		return this.cadastroF.remover(nome);
	}
	
	public boolean editarFilme(Filme filme){
		return this.cadastroF.editar(filme);
	}
	/*
	public void listarFilme(){
		return this.cadastroF.lista();
	}*/
	
	//INGRESSO
	
	public boolean cadastrarIngresso(Ingresso ingresso){
		return this.cadastroI.cadastrar(ingresso);
	}
	
	public boolean removerIngresso(int id){
		return this.cadastroI.remover(id);
	}
	
	public float totalFinanceiroIngresso(){
		return this.cadastroI.totalFinanceiro();
	}
	
	//SALA
	
	public boolean adicionarSala(Salas sala){
		return this.cadastroSa.adicionar(sala);
	}
	
	public boolean removerSala(Salas sala){
		return this.cadastroSa.remover(sala);
	}
	
	public Salas procurarIdSala(int idSala){
		return this.cadastroSa.procurarId(idSala);
	}
	
	public String procurarTipoSala(int idSala){
		return this.cadastroSa.procurarTipo(idSala);
	}
	
	public boolean editarSala(Salas sala){
		return this.cadastroSa.editar(sala);
	}
	
	//SESSAO
	
	public boolean adicionarSessao(Sessao sessao){
		return this.cadastroSe.adicionarSessao(sessao);
	}
	
	public boolean removerSessao(Sessao sessao){
		return this.cadastroSe.removerSessao(sessao);
	}
	
	public boolean conferirHorarioSessao(){
		return this.cadastroSe.conferirHorario();
	}
	
	public ArrayList<Sessao> buscarSessaoPorFilme(Filme filme){
		return this.cadastroSe.buscarPorFilme(filme);
	}
	
	public ArrayList<Sessao> buscarSessaoPorSala(Salas sala){
		return this.cadastroSe.buscarPorSala(sala);
	}
}
