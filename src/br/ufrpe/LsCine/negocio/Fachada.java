package br.ufrpe.LsCine.negocio;

import java.util.ArrayList;
import br.ufrpe.LsCine.dados.*;
import br.ufrpe.LsCine.negocio.beans.*;
import br.ufrpe.LsCine.exceptions.FilmeExistenteException;
import br.ufrpe.LsCine.exceptions.LoginIncorretoException;

public class Fachada {

	private CadastroFilme cadastroF;
	private CadastroIngresso cadastroI;
	private CadastroSalas cadastroSa;
	private CadastroSessao cadastroSe;
	private CadastroConta cadastroCo;
	private static Fachada instancia; 
	
	private Fachada(){
		this.cadastroF = new CadastroFilme(new RepositorioFilme());
		this.cadastroI = new CadastroIngresso(new RepositorioIngresso());
		this.cadastroSa = new CadastroSalas(new RepositorioSalas());
		this.cadastroSe = new CadastroSessao(new RepositorioSessao());
		this.cadastroCo = new CadastroConta(new RepositorioConta());
	}
	
	public static Fachada getInstancia(){
		if(instancia==null){
			instancia = new Fachada();
		}
		return instancia; 
	}
	
	//FILME 
	
	public boolean cadastrarFilme(Filme filme) throws FilmeExistenteException{
		return this.cadastroF.cadastrar(filme);
	}
	
	public Filme buscarFilme(String nome){
		return this.cadastroF.buscar(nome);
	}
	
	public boolean removerFilme(String nome){
		return this.cadastroF.remover(nome);
	}
	
	public boolean editarFilme(Filme filme){
		return this.cadastroF.editar(filme);
	}
	
	public ArrayList<Filme> listarFilme(){
		return this.cadastroF.listar();
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
	
	public ArrayList<Salas> listarSalas(){
		return this.cadastroSa.listar();
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
	
	/*public void buscarSessaoPorFilme(String nome){
		this.cadastroSe.buscarPorFilme(nome);
	}
	
	public void buscarSessaoPorSala(int sala){
		this.cadastroSe.buscarPorSala(sala);
	}*/
	
	//CONTA

	public boolean adicionarConta(Conta conta){
		return this.cadastroCo.adicionarConta(conta);
	}
	
	public boolean removerConta(Conta login){
		return this.cadastroCo.removerConta(login);
	}
	
	public boolean logar(String login, String senha) throws LoginIncorretoException{
		return this.cadastroCo.logar(login, senha);
	}

	//GETTERS E SETTERS

	public CadastroConta getCadastroCo() {
		return cadastroCo;
	}

	public void setCadastroCo(CadastroConta cadastroCo) {
		this.cadastroCo = cadastroCo;
	}

	public CadastroFilme getCadastroF() {
		return cadastroF;
	}

	public void setCadastroF(CadastroFilme cadastroF) {
		this.cadastroF = cadastroF;
	}

	public CadastroIngresso getCadastroI() {
		return cadastroI;
	}

	public void setCadastroI(CadastroIngresso cadastroI) {
		this.cadastroI = cadastroI;
	}

	public CadastroSalas getCadastroSa() {
		return cadastroSa;
	}

	public void setCadastroSa(CadastroSalas cadastroSa) {
		this.cadastroSa = cadastroSa;
	}

	public CadastroSessao getCadastroSe() {
		return cadastroSe;
	}

	public void setCadastroSe(CadastroSessao cadastroSe) {
		this.cadastroSe = cadastroSe;
	}
	
}
