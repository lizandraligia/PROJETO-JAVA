package negocio;
import java.util.Scanner;
import negocio.beans.Filme;

public class Main {

	Fachada fachada = new Fachada();
	int opcao;
	Scanner input = new Scanner(System.in);
		
	public void menu(){
	
		System.out.println("Bem-vindo!\n");
		System.out.println("1- Gerenciamento de filmes");
		System.out.println("2- Gerenciamento de sess�es");
		System.out.println("3- Gerenciamento de salas");
		System.out.println("4- Relatorio de lucro");
		System.out.println("Escolha uma op��o: ");
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
					System.out.println("T�tulo: ");
					String nom = input.nextLine();
					nom = input.nextLine();
					System.out.println("Dura��o(em minutos): ");
					int dur = input.nextInt();
					System.out.println("Classifi��o indicativa: ");
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
					System.out.println("T�tulo do filme que deseja buscar: ");
					String busca = input.nextLine();
					busca = input.nextLine();
					Filme resultado = fachada.buscarFilme(busca);
					if(resultado==null){
						System.out.println("Filme n�o encontrado.");
					}
					else{
						System.out.println(resultado);
					}
					break;
				}
				case 3: {
					System.out.println("Remover filme.");
					System.out.println("T�tulo do filme que deseja remover:");
					String remove = input.nextLine();
					remove = input.nextLine();
					fachada.removerFilme(remove);
					System.out.println("Filme removido.");
					break;
				}
				case 4: { //erro
					System.out.println("Modificar dados de filme.");
					System.out.println("T�tulo do filme que deseja modificar: ");
					String busca = input.nextLine();
					busca = input.nextLine();
					Filme filme = fachada.buscarFilme(busca);
					System.out.println(filme);
					System.out.println("T�tulo: ");
					String n = input.next();
					n = input.nextLine();
					System.out.println("Dura��o: ");
					int d = input.nextInt();
					System.out.println("Classifica��o indicativa:");
					int c = input.nextInt();
					fachada.editarFilme(new Filme(n,d,c));
					System.out.println("Modifica��o realizada com sucesso!");
					
					break;				
				}
				case 5: {
					System.out.println("Nome do filme:");
					String b = input.nextLine();
					b = input.nextLine();
					Filme filme = fachada.buscarFilme(b);
					System.out.println(filme);
					//int tipo, float valor, Sess�o sessao, int id
					System.out.println("Tipo de ingresso:");
					System.out.println("1-Inteira");
					System.out.println("2-Meia");
					
					int t = input.nextInt();
					//fachada.cadastrarIngresso(new Ingresso(t));
					
					break;
				}
				default: {
					System.out.println("Opcao indispon�vel.");
					break;
				}		
			}	
		}while(opcao!=6);
	}
	
	
	public void gerenciarSessoes(){
		
	}
	
	public void gerenciarSalas(){
		
	}
	
	public void relatorioLucro(){
		
	}
}

