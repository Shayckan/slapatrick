package trabpatrick;

import java.util.Scanner;

public class Funcionario 
{
    String nome;
    int id;
    String cargo;
    float tvendas;
    int tpedidos;

    public Funcionario(String nome, int id, String cargo) 
    {
        this.nome = nome;
        this.id = id;
        this.cargo = cargo;
        this.tvendas = 0.0f;
        this.tpedidos = 0;
    }

    public static Funcionario criarFuncionario() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entre com o nome do funcionário: ");
        String nome = scanner.nextLine();
        
        System.out.print("ID do funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print(" função do funcionario: ");
        String cargo = scanner.nextLine();
        
        return new Funcionario(nome, id, cargo);
    }
}