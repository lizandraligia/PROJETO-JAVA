package br.ufrpe.LsCine.interfaces;

import java.util.ArrayList;
import br.ufrpe.LsCine.negocio.beans.Sessao;

public interface IRepositorioSessao {

	public boolean adicionar(Sessao sessao);	
	public Sessao procurar(int codigo);	
	public boolean remover(int numero);	
	public boolean alterar(Sessao sala);	
	public ArrayList<Sessao> listar();
	public void listarNome(String nome);
	public Sessao buscarNome(String nome);
	public boolean conferirHorario(int sala, Date hrinicio, Date hrfim);
	
}
