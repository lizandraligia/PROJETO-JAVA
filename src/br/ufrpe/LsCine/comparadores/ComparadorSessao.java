package br.ufrpe.LsCine.comparadores;

import java.util.Comparator;

import br.ufrpe.LsCine.negocio.beans.Sessao;

public class ComparadorSessao implements Comparator<Sessao>{

	public int compare(Sessao s1, Sessao s2){
		return s1.getNome().compareTo(s2.getNome());
	}
}
