package trabpatrick;

import java.util.Scanner;

public class Cardapio {
	
	String nome;
	String codigo;
	double preco;
	int quantidade;
	boolean disponibilidade;
	
	public Cardapio (String nome, String codigo, double preco, boolean disponibilidade,int quantidade)
	{
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
		this.quantidade = quantidade;
		this.disponibilidade = quantidade > 0;
		
	}
	public static Cardapio criarCardapio() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print ("Entre com o nome do prato/bebida: ");
		String nome = scanner.nextLine();
		
		System.out.print("Digite o codigo do alimento/bebida: ");
		String codigo = scanner.nextLine();
		
		System.out.print("Entre com o valor da comida: ");
		double preco = scanner.nextDouble();
		
		System.out.println ("Disponibilidade (True) or (False)");
		
		
		
		
	}

}
