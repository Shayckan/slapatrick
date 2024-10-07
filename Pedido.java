package trabpatrick;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Pedido {
   
    private Mesa mesa;
    private Funcionario funcionario;
    private ArrayList<Cardapio> itens;
    private double total;
    private Date data;
	
	public Pedido (Mesa mesa, Funcionario funcionario)
	{
		this.mesa = mesa;
		this.funcionario = funcionario;
		this.itens = new ArrayList<>();
		this.total = 0.0;
		this.data = new Date();
		mesa.ocuparMesa();
	}
	
	public void adicionarItem (Cardapio item)
	{
		if (item.disponibilidade)
		{
			itens.add(item);
			total+=item.preco;
			item.quantidade--;
			item.disponibilidade = item.quantidade > 0;
			
		}
		else
		{
			System.out.println ("O item" + item.nome + " não está disponivel no momento.");
		}
	}
	double getTotal()
	{
		return total;
	}
	public void fecharConta()
	{
		mesa.liberarMesa();
		System.out.print ("Conta fechada para a mesa " + mesa.numero + ". Total: "+ total);
	}
	public Mesa getMesa() 
	{
		return mesa;
	}
	
	public Funcionario getFuncionario() {
        return funcionario;
	}
	
	public ArrayList<Cardapio> getItens()
	{
		return itens;
	}
	
	public Date getData() 
	{
		return data;
	}
	
	public static void Relatorio (List<Pedido> pedidos)
	{
		double totalVendas = 0.0;
		Map<Mesa, Double> vendasPorMesa = new HashMap<>();
        Map<Funcionario, Double> vendasPorFuncionario = new HashMap<>();

		for (Pedido pedido : pedidos)
		{
			totalVendas += pedido.getTotal();
			vendasPorMesa.put(pedido.getMesa(), vendasPorMesa.getOrDefault(pedido.getMesa(),0.0) + pedido.getTotal());
            vendasPorFuncionario.put(pedido.getFuncionario(), vendasPorFuncionario.getOrDefault(pedido.getFuncionario(), 0.0) + pedido.getTotal());
		}  
		
		
		
		System.out.println ("Telatorio de Faturamento: ");
		System.out.println ("Total de vendas realizadas no dia: " + totalVendas);
		
		System.out.println ("Total de vendas por mesa: ");
		for (Map.Entry<Mesa, Double> entry : vendasPorMesa.entrySet())
		{
			System.out.println ("Mesa " + entry.getKey().numero + ": " + entry.getValue());
		}
		
		System.out.println ("Total de vendas por funcionario: ");
		for (Map.Entry < Funcionario, Double > entry : vendasPorFuncionario.entrySet())
		{
            System.out.println("Funcionário " + entry.getKey().nome + ": " + entry.getValue());
		}
		
		
	}
	
	}
