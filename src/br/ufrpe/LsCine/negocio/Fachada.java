package br.ufrpe.LsCine.negocio;

import br.ufrpe.LsCine.negocio.beans.*;

public class Fachada {

	private CadastroFilme cadastroF;
	private CadastroIngresso cadastroI;
	private CadastroSalas cadastroSa;
	private CadastroSessao cadastroSe;
	private CadastroConta cadastroCo;
	private static Fachada instancia; 
	
	private Fachada(){
		this.cadastroF = new CadastroFilme();
		this.cadastroI = new CadastroIngresso();
		this.cadastroSa = new CadastroSalas();
		this.cadastroSe = new CadastroSessao();
		this.cadastroCo = new CadastroConta();
	}
	
	public static Fachada getInstancia(){
		if(instancia==null){
			instancia = new Fachada();
		}
		return instancia; 
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
	
	public void listarFilme(){
		this.cadastroF.lista();
	}
	
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
	
	public boolean removerSala(int idSala){
		return this.cadastroSa.remover(idSala);
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
	
	public void listarSalas(){
		this.cadastroSa.listar();
	}
	
	//SESSAO
	
	public boolean adicionarSessao(Sessao sessao){
		return this.cadastroSe.adicionarSessao(sessao);
	}
	
	public boolean removerSessao(int id){
		return this.cadastroSe.removerSessao(id);
	}
	
	/*public boolean conferirHorarioSessao(){
		return this.cadastroSe.conferirHorario();
	}*/
	
	public void listarSessoes(){
		this.cadastroSe.listar();
	}
	
	public void buscarSessaoPorFilme(String nome){
		this.cadastroSe.buscarPorFilme(nome);
	}
	
	public void buscarSessaoPorSala(int sala){
		this.cadastroSe.buscarPorSala(sala);
	}
	
	//CONTA
	
	public void adicionarConta(Conta conta){
		this.cadastroCo.adicionarConta(conta);
	}
	
	public void removerConta(String login){
		this.cadastroCo.removerConta(login);
	}
	
	public boolean logar(Conta login){
		return this.cadastroCo.logar(login);
	}
	
	public void listaContas(){
		this.cadastroCo.listaContas();
	}
	
}
