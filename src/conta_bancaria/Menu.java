package conta_bancaria;

import java.util.Scanner;
/*Importamos o pacote java.util.Scanner que permite a entrada de dados pelo teclado. 
 * Esse recurso será utilizado para capturar as opções escolhidas pelo usuário no menu.
 */
import conta_bancaria.model.Conta; // importada a classr Conta do pacote .model e declarada nas variaveis abaixo
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
/* 
 * Importamos a Classe Cores, responsável por definir constantes que permitem 
 * aplicar cores aos textos e planos de fundo nos comandos de saída no console.
 */

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		/*
		 * Instanciamos um objeto da classe Scanner, chamado leia, que será responsável
		 * por capturar as entradas digitadas pelo usuário no teclado.
		 */
		int opcao;
		/*
		 * Declaramos a variável do tipo int chamada opcao, que armazenará o número
		 * correspondente à opção do menu escolhida pelo usuário.
		 */
/*
		//Testes da Classe Conta
		Conta c1 = new Conta(1, 123, 1, "Cintia Dourado", 505000.00f);
		c1.setSaldo(600000.00f); // atualizando o saldo
		c1.visualizar();
		//Teste Sacar da Conta 1 - Cintia
		System.out.println(c1.sacar(1000));
		System.out.println("O Saldo da Conta 1 (Cintia) apos o saque eh: " + c1.getSaldo());
		//Teste Depositar na Conta 1 - Cintia
		c1.depositar(5000);
		System.out.println("O Saldo da Conta 1 (Cintia) apos o deposito eh: " + c1.getSaldo());

			
		Conta c2 = new Conta(2, 456, 1, "Priscila Lins", 503000.00f);
		c2.visualizar();
		//Teste Sacar da Conta 2 - Priscila
		System.out.println(c2.sacar(10000000));
		System.out.println("O Saldo da Conta 2 (Priscila) apos o saque eh: "+ c2.getSaldo());
		//Teste Depositar na Conta 2 - Priscila
		c2.depositar(1000);
		System.out.println("O Saldo da Conta 2 (Priscila) apos o deposito eh: " + c2.getSaldo());
*/
		
		// Instanciar Objetos da Classe ContaCorrente - Testes		
		ContaCorrente c3 = new ContaCorrente(3, 789 ,1, "Thuany Silva", 1000000.00f, 1000000.00f);
		c3.visualizar();
		System.out.println(c3.sacar(2000.00f)); //Teste Sacar da Conta 3
		c3.visualizar();
		System.out.println(c3.sacar(2000000.00f)); //Teste Sacar da Conta 3
		c3.visualizar();
		c3.depositar(5000.00f); //Teste DEPOSITAR na Conta 3
		c3.visualizar();
		
		// Instanciar Objetos da Classe ContaPoupanca - Testes		
		ContaPoupanca cp1 = new ContaPoupanca(4, 001 ,2, "Maria Joana", 50000.00f, 15);
		cp1.visualizar();
		System.out.println(cp1.sacar(2000000.00f)); //Teste Sacar da ContaP 4
		cp1.visualizar();
		System.out.println(cp1.sacar(2000.00f)); //Teste Sacar da ContaP 4
		cp1.visualizar();
		cp1.depositar(5000.00f); //Teste DEPOSITAR na ContaP 4
		cp1.visualizar();
		
		
		while (true) {
			/*
			 * Iniciamos a estrutura de repetição while, que será responsável por exibir o
			 * menu continuamente. A condição true indica que o laço será infinito, ou seja,
			 * continuará em execução até que ocorra uma instrução de interrupção manual —
			 * neste caso, quando a opção 0 for selecionada.
			 */
			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_CYAN_BACKGROUND
					+ "••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
			/*
			 * Antes do conteúdo do comando System.out.println(), concatenamos as constantes
			 * de Cores.TEXT_PURPLE e Cores.ANSI_CYAN_BACKGROUND definindo que o texto será
			 * exibido em rosa, com fundo azul.
			 */
			System.out.println("                                                                ");
			System.out.println("                          BANCO DOURADO                         ");
			System.out.println("                                                                ");
			System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
			System.out.println("                                                                ");
			System.out.println("                         MENU DE OPÇOES                         ");
			System.out.println("                                                                ");
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("                 1 - Criar Conta                                ");
			System.out.println("                 2 - Listar Todas as Contas                     ");
			System.out.println("                 3 - Buscar Conta por Número                    ");
			System.out.println("                 4 - Consultar uma Conta pelo titular           ");
			System.out.println("                 5 - Atualizar Dados da Conta                   ");
			System.out.println("                 6 - Excluir Conta                              ");
			System.out.println("                 7 - Sacar dinheiro em Espécie                  ");
			System.out.println("                 8 - Depositar dinheiro                         ");
			System.out.println("                 9 - Transferir Valores entre Contas            ");
			System.out.println("                 0 - SAIR                                       ");
			System.out.println("                                                                ");
			System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
			System.out.println("Por favor, entre com a opçao desejada:                          ");
			System.out.println("                                                                " + Cores.TEXT_RESET);
			/*
			 * Após o conteúdo do comando System.out.println(), concatenamos a constante
			 * Cores.TEXT_RESET, garantindo que o texto e o plano de fundo voltem ao padrão
			 * após a exibição do menu.
			 */
			/*
			 * Construímos a estrutura visual do menu. Os espaços em branco ao redor dos
			 * itens e as linhas vazias foram criados com espaços simples, e não com
			 * tabulações (tecla Tab). Isso garante que a formatação fique uniforme ao ser
			 * exibida no terminal.
			 */

			opcao = leia.nextInt();

			/*
			 * Utilizamos o método nextInt() do objeto leia para ler a entrada do usuário
			 * como um número inteiro, atribuindo o valor à variável opcao.
			 */

			if (opcao == 0) {
				System.out.println(Cores.TEXT_PURPLE_BOLD + Cores.ANSI_CYAN_BACKGROUND
						+ "\nBanco Dourado - O seu fututo começa aqui");
				/*
				 * concatenamos a constante Cores.TEXT_PURPLE_BOLDD, para exibir a mensagem de
				 * finalização do programa em rosa com negrito.
				 */
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Criar Nova Conta!\n\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Listar Todas as Contas!\n\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados de conta - por número!\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados de conta - por titular da conta!\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Atualizar dados bancários!\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Deletar a Conta!\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Saque!\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Depósito!\n\n");
				break;
			case 9:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Transferência entre contas!\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opçao inválida! \nPor favor, escolha uma opçao válida.\n\n");
				break;
			/*
			 * Em todas essas linhas, antes dos comandos System.out.println(), também
			 * adicionamos a constante Cores.TEXT_****_BOLD, garantindo que as mensagens de
			 * cada opção do menu sejam exibidas com destaque.
			 */
			/*
			 * Utilizamos a estrutura switch (condicional por casos) para tratar as opções
			 * de 1 a 8. Cada número acionará uma mensagem específica, simulando
			 * funcionalidades futuras. Se a entrada do usuário não corresponder a nenhuma
			 * dessas opções, será exibida a mensagem "Opção Inválida!".
			 */

			}

		}

	}

	public static void sobre() {
		System.out.println("\n••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println("Projeto Desenvolvido por: Cintia Marques Dourado                  ");
		System.out.println("Generation Brasil -- CintiaD@genstidents.org   	                   ");
		System.out.println("https://github.com/cdouradom/Conta-Bancaria                   ");
		System.out.println("\n••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
	}
}
