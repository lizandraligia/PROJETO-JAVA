package br.ufrpe.LsCine.interfaces;

import java.util.ArrayList;
import br.ufrpe.LsCine.negocio.beans.Salas;

public interface IRepositorioSalas {
	
	public boolean adicionar(Salas sala);	
	public Salas procurar(int codigo);	
	public boolean remover(int numero);	
	public boolean alterar(Salas sala);	
	public ArrayList<Salas> listar();
	public int buscar(Salas sala);	

}
