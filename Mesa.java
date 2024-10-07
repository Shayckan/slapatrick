package trabpatrick;

import java.util.Scanner;

public class Mesa 
{
    int numero;
    int capacidade;
    boolean ocupada;

    public Mesa(int numero, int capacidade) 
    {
        this.numero = numero;
        this.capacidade = capacidade;
        this.ocupada = false;
    }

    public void ocuparMesa() 
    {
        this.ocupada = true;
    }

    public void liberarMesa() 
    {
        this.ocupada = false;
    }

    
    public static Mesa criarMesa() 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com o número da mesa: ");
        int numero = scanner.nextInt();

        System.out.print("Entre com a capacidade da mesa: ");
        int capacidade = scanner.nextInt();

        return new Mesa(numero, capacidade);
    }
}