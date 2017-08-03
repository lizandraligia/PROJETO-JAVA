package br.ufrpe.LsCine;

import  br.ufrpe.LsCine.gui.Tela;
import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.*;

public class Principal {

	public static void main(String[] args) throws FilmeExistenteException{

		Tela tela = Tela.getInstancia();
		Fachada fachada = Fachada.getInstancia();
		
		//Alguns filmes pre cadastrados 
		Filme f1 = new Filme("Toy Story",100,1);
		fachada.cadastrarFilme(f1);
		Filme f2 = new Filme("Titanic",120,4);
		fachada.cadastrarFilme(f2);
		Filme f3 = new Filme("Harry Potter",90,3);
		fachada.cadastrarFilme(f3);
		
		//Algumas salas pre cadastradas
		Salas s1 = new Salas(1,true,false);
		fachada.adicionarSala(s1);
		Salas s2 = new Salas(2,true,true);
		fachada.adicionarSala(s2);
		Salas s3 = new Salas(3,false,false);
		fachada.adicionarSala(s3);
		
		tela.menu();
	}
}
