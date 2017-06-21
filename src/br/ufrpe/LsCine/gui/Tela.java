package br.ufrpe.LsCine.gui;

import java.util.Scanner;

import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.negocio.beans.Salas;

public class Tela {
	
	Fachada fachada = new Fachada();
	int opcao;
	Scanner input = new Scanner(System.in);
		
	public void menu(){
	
		System.out.println("Bem-vindo!\n");
		System.out.println("1- Gerenciamento de filmes");
		System.out.println("2- Gerenciamento de sessões");
		System.out.println("3- Gerenciamento de salas");
		System.out.println("4- Relatorio de lucro");
		System.out.println("Escolha uma opção: ");
		int resp = input.nextInt();
		switch(resp){
			case 1:{
				this.gerenciarFilmes();
				break;
			}
			case 2:{
				this.gerenciarSessoes();
				break;
			}
			case 3:{
				this.gerenciarSalas();
				break;
			}
			case 4:{
				this.relatorioLucro();
				break;
			}
		}
	}
	
	
	public void gerenciarFilmes(){
		System.out.println("Gerenciamento de filmes. Escolha a opcao desejada:");
		System.out.println("1-Cadastrar");
		System.out.println("2-Buscar");
		System.out.println("3-Remover");
		System.out.println("4-Alterar dados");
		System.out.println("5-Comprar ticket");
		System.out.println("6-Voltar.");
		
		do{
			opcao = input.nextInt();
			
			switch(opcao){
				case 1: {
					System.out.println("Cadastrar filme.");
					System.out.println("Título: ");
					String nom = input.nextLine();
					nom = input.nextLine();
					System.out.println("Duração(em minutos): ");
					int dur = input.nextInt();
					System.out.println("Classifição indicativa: ");
					System.out.println("1- Livre");
					System.out.println("2- +10");
					System.out.println("3- +12");
					System.out.println("4- +14");
					System.out.println("5- +16"); 
					System.out.println("6- +18");
					int cls = input.nextInt();
					fachada.cadastrarFilme(new Filme(nom,dur,cls));
					System.out.println("Cadastro realizado!\n");
					
					break;
				}
				case 2: {
					System.out.println("Buscar filme.");
					System.out.println("Título do filme que deseja buscar: ");
					String busca = input.nextLine();
					busca = input.nextLine();
					Filme resultado = fachada.buscarFilme(busca);
					if(resultado==null){
						System.out.println("Filme não encontrado.");
					}
					else{
						System.out.println(resultado);
					}
					break;
				}
				case 3: {
					System.out.println("Remover filme.");
					System.out.println("Título do filme que deseja remover:");
					String remove = input.nextLine();
					remove = input.nextLine();
					fachada.removerFilme(remove);
					System.out.println("Filme removido.");
					break;
				}
				case 4: { //erro
					System.out.println("Modificar dados de filme.");
					System.out.println("Título do filme que deseja modificar: ");
					String busca = input.nextLine();
					busca = input.nextLine();
					Filme filme = fachada.buscarFilme(busca);
					System.out.println(filme);
					System.out.println("Título: ");
					String n = input.next();
					n = input.nextLine();
					System.out.println("Duração: ");
					int d = input.nextInt();
					System.out.println("Classificação indicativa:");
					int c = input.nextInt();
					fachada.editarFilme(new Filme(n,d,c));
					System.out.println("Modificação realizada com sucesso!");
					
					break;				
				}
				case 5: {
					System.out.println("Nome do filme:");
					String b = input.nextLine();
					b = input.nextLine();
					Filme filme = fachada.buscarFilme(b);
					System.out.println(filme);
					//int tipo, float valor, Sessão sessao, int id
					System.out.println("Tipo de ingresso:");
					System.out.println("1-Inteira");
					System.out.println("2-Meia");
					
					int t = input.nextInt();
					//fachada.cadastrarIngresso(new Ingresso(t));
					
					break;
				}
				default: {
					System.out.println("Opcao indisponível.");
					break;
				}		
			}	
		}while(opcao!=6);
	}
	
	
	public void gerenciarSessoes(){
		System.out.println("Gerenciamento de sessões. Escolha a opcao desejada:");
		System.out.println("1-Criar sessão");
		System.out.println("2-Buscar");
		System.out.println("3-Remover");
		
		do{
			opcao = input.nextInt();
			
			switch(opcao){
				case 1: {//public Sessão(Filme filme, Salas sala, Date hrinicio, float valor)
					System.out.println("Criar sessão.");
					System.out.println("Filme: ");
					
					//Filme(String nome, int duracao, int classificacao)
					
					//fachada.adicionarSessao(sessao);
					break;
				} 
				case 2:{
					System.out.println("Buscar sala por numero.");
					System.out.println("Numero: ");
					int numero = input.nextInt();
					Salas resultado = fachada.procurarIdSala(numero);	
					if(resultado==null){
						System.out.println("Sala não encontrada.");
					}
					else{
						System.out.println(resultado);
					}
					break;
				}
			}
		}while(opcao!=4);
	}
	
	public void gerenciarSalas(){
		System.out.println("Gerenciamento de salas. Escolha a opcao desejada:");
		System.out.println("1-Criar sala");
		System.out.println("2-Buscar");
	
		do{
			opcao = input.nextInt();
			
			switch(opcao){
				case 1: {
					System.out.println("Criar sala.");
					System.out.println("Numero da sala: ");
					int num = input.nextInt();
					System.out.println("Tipo de sessão(true or false):");
					System.out.println("1- 3D");
					boolean s3d = input.nextBoolean();
					System.out.println("2- IMAX 3D");
					boolean imax = input.nextBoolean();
					fachada.adicionarSala(new Salas(num,s3d,imax));
					break;
				} 
				case 2:{
					System.out.println("Buscar sala por numero.");
					System.out.println("Numero: ");
					int numero = input.nextInt();
					Salas resultado = fachada.procurarIdSala(numero);	
					if(resultado==null){
						System.out.println("Sala não encontrada.");
					}
					else{
						System.out.println(resultado);
					}
					break;
				}
			}
		}while(opcao!=3);
	}

	public void relatorioLucro(){
		
	}
}
