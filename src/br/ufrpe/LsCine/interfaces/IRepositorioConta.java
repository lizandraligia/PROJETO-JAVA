package br.ufrpe.LsCine.interfaces;

import br.ufrpe.LsCine.negocio.beans.Conta;
import java.util.ArrayList;

public interface IRepositorioConta {

	public boolean adicionar(Conta conta);
	
	public Conta buscar(Conta conta);
	
	public boolean remover(Conta login);
	
	public ArrayList<Conta> getContas();
}
