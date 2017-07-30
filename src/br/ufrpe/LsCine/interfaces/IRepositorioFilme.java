package br.ufrpe.LsCine.interfaces;

import br.ufrpe.LsCine.negocio.beans.Filme;
import java.util.ArrayList;

public interface IRepositorioFilme {

	public boolean inserirFilme(Filme filme);
	
	public Filme buscarFilme(String nome);
	
	public boolean removerFilme(String nome);
	
	public boolean editarFilme(Filme filme);
	
	public ArrayList<Filme> listar();
}
