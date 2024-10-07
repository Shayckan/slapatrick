package trabpatrick;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main (String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		List<Funcionario> funcionarios = new ArrayList<>();
		List<Mesa> mesas = new ArrayList<>();
		List<Cardapio> cardapio = new ArrayList<>();
		List<Pedido> pedidos = new ArrayList<>();
		
		int opcao;
		
		do
		{
			System.out.println ("\n Menu: ");
			System.out.println ("1. Cadastrar Funcionários ");
			System.out.println ("2. Cadastrar mesa ");
			System.out.println ("3. Cadastrar item no cardapio ");
			System.out.println ("4. Fazer pedido ");
			System.out.println ("5. Relatorio do Faturameto ");
			System.out.println ("6. Sair ");
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao)
			{
			case 1:
                Funcionario novoFuncionario = Funcionario.criarFuncionario();
                funcionarios.add(novoFuncionario);
                System.out.println ("Funcionario cadastrado!");
                break;
			
			case 2:
				Mesa novaMesa = Mesa.criarMesa();
				mesas.add(novaMesa);
				System.out.println ("Mesa reservada com exito!");
				break;
				
			case 3:
				Cardapio novoItem = Cardapio.criarCardapio();
				cardapio.add(novoItem);
				System.out.println ("Item cadastrado");
				
			case 4:
				System.out.println ("Selecione uma mesa:");
				for (Mesa mesa : mesas)
				{
					System.out.println ("Mesa "+ mesa.numero + "- Capacidade: " + mesa.capacidade);
					
				}
				int mesaEscolhida = scanner.nextInt();
				Mesa mesaSelecionada = mesas.stream()
                        .filter(m -> m.numero == mesaEscolhida)
                        .findFirst()
                        .orElse(null);
				
				if (mesaSelecionada != null)
				{
					  System.out.println("Selecione um funcionário:");
                      for (Funcionario func : funcionarios) {
                          System.out.println("ID: " + func.id + " - Nome: " + func.nome);
                      }
                      int idFuncionario = scanner.nextInt();
                      Funcionario funcionarioSelecionado = funcionarios.stream()
                              .filter(f -> f.id == idFuncionario)
                              .findFirst()
                              .orElse(null);
                      
                      if (funcionarioSelecionado != null) {
                          Pedido pedido = new Pedido(mesaSelecionada, funcionarioSelecionado);
                          boolean adicionarMaisItens = true;

                          while (adicionarMaisItens) {
                              System.out.println("Selecione um item do cardápio:");
                              for (Cardapio item : cardapio) {
                                  System.out.println("Código: " + item.codigo + " - Nome: " + item.nome + " - Preço: " + item.preco + " - Disponível: " + item.quantidade);
                              }
                              int codigoItemEscolhido = scanner.nextInt();
                              Cardapio itemSelecionado = cardapio.stream()
                                      .filter(i -> i.codigo == codigoItemEscolhido)
                                      .findFirst()
                                      .orElse(null);
                              
                              if (itemSelecionado != null) {
                                  pedido.adicionarItem(itemSelecionado);
                                  System.out.println("Item adicionado ao pedido.");
                              } else {
                                  System.out.println("Item não encontrado.");
                              }

                              System.out.print("Deseja adicionar mais itens? (s/n): ");
                              String resposta = scanner.next();
                              adicionarMaisItens = resposta.equalsIgnoreCase("s");
                          }

                          pedidos.add(pedido);
                          System.out.println("Pedido registrado com sucesso!");
                      } else {
                          System.out.println("Funcionário não encontrado.");
                      }
                  } else {
                      System.out.println("Mesa não encontrada.");
                  }
                  break;

              case 5:
                 
                  RelatorioFaturamento.gerarRelatorio(pedidos);
                  break;

              case 6:
                  System.out.println("Saindo...");
                  break;

              default:
                  System.out.println("Opção inválida, tente novamente.");
          }
      } while (opcao != 6);

      scanner.close();
  }
}