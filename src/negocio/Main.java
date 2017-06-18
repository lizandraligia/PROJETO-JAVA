package negocio;
import java.util.Scanner;
import negocio.beans.Filme;

public class Main {

	public static void main(String[] args) {
		
		Fachada fachada = new Fachada();
		int opcao;
		Scanner input = new Scanner(System.in);
		
		System.out.println("BEM-VINDO!\n");
		System.out.println("1-CADASTRAR FILME");
		System.out.println("2-BUSCAR FILME");
		System.out.println("3-REMOVER FILME");
		System.out.println("4-ALTERAR DADOS DE FILME");
		System.out.println("5-LISTA DE FILMES EM CARTAZ");
		System.out.println("6-SAIR.");
		
		do{
			System.out.println("ESCOLHA A OPCAO DESEJADA:");
			opcao = input.nextInt();
			
			switch(opcao){
				case 1: {
					System.out.println("CADASTRAR FILME");
					System.out.println("TÍTULO: ");
					String nom = input.nextLine();
					nom = input.nextLine();
					System.out.println("DURACAO: ");
					int dur = input.nextInt();
					System.out.println("CLASSIFICACAO INDICATIVA: ");
					System.out.println("1- LIVRE");
					System.out.println("2- +10");
					System.out.println("3- +12");
					System.out.println("4- +14");
					System.out.println("5- +16"); 
					System.out.println("6- +18");
					int cls = input.nextInt();
					fachada.cadastrarFilme(new Filme(nom,dur,cls));
					System.out.println("CADASTRO REALIZADO!\n");
					
					break;
				}
				case 2: {
					System.out.println("BUSCAR FILME");
					System.out.println("INFORME O FILME QUE DESEJA BUSCAR: ");
					String busca = input.nextLine();
					busca = input.nextLine();
					Filme resultado = fachada.buscarFilme(busca);
					if(resultado==null){
						System.out.println("FILME NAO ENCONTRADO.");
					}
					else{
						System.out.println(resultado);
					}
					break;
				}
				case 3: {
					System.out.println("REMOVER FILME");
					System.out.println("INFORME O NOME DO FILME QUE DESEJA REMOVER:");
					String remove = input.nextLine();
					remove = input.nextLine();
					fachada.removerFilme(remove);
					System.out.println("FILME REMOVIDO.");
					break;
				}
				case 4: {
					System.out.println("ALTERAR DADOS DE FILME");
					System.out.println("INFORME O NOME DO FILME QUE DESEJA ALTERAR: ");
					String busca = input.nextLine();
					busca = input.nextLine();
					Filme filme = fachada.buscarFilme(busca);
					System.out.println(filme);
					System.out.println("NOME: ");
					String n = input.nextLine();
					n = input.nextLine();
					System.out.println("DURACAO: ");
					int d = input.nextInt();
					System.out.println("CLASSIFICACAO INDICATIVA:");
					int c = input.nextInt();
					if(fachada.editarFilme(new Filme(n,d,c))==true){
						System.out.println("ALTERACAO REALIZADA COM SUCESSO!");
					}
					break;				
				}/*
				case 5: {
					System.out.println("FILMES EM CARTAZ:");

					break;
				}*/
				default: {
					System.out.println("OPCAO INDISPONIVEL.");
					break;
				}		
			}	
		}while(opcao!=6);
	}
}
