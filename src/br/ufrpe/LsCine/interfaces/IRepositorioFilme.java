package br.ufrpe.LsCine.interfaces;

import br.ufrpe.LsCine.negocio.beans.Filme;

public interface IRepositorioFilme {

	public boolean inserirFilme(Filme filme);
	
	public boolean existe(String nome);
	
	public Filme buscarFilme(String nome);
	
	public boolean removerFilme(String nome);
	
	public boolean editarFilme(Filme filme);
	
	public void listarFilmes();
}
