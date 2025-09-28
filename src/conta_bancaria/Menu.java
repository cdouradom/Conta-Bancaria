package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
/*Importamos o pacote java.util.Scanner que permite a entrada de dados pelo teclado. 
 * Esse recurso será utilizado para capturar as opções escolhidas pelo usuário no menu.
 */
import conta_bancaria.model.Conta; // importada a classe Conta do pacote .model que eh declarada nas variaveis abaixo
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
// Importamos a Classe Cores, que permitem aplicar cores aos textos e planos de fundo nos comandos de saída no console.

public class Menu {

	private static final Scanner leia = new Scanner(System.in); // responsável por capturar as entradas digitadas pelo usuário no teclado.
	private static final ContaController contaController = new ContaController(); // responsável por armazenar os dados das contas na coleção listaContas e executar os métodos do CRUD, bem como os métodos bancários da aplicação.

	public static void main(String[] args) {

		criarContasTeste(); // declarando a variavel para criar contas testes depois de cirar o metodo para inserir pelo codigo e testar

		int opcao; // Declaramos a variável do tipo int chamada opcao, que armazenará o número

		while (true) {
			/*
			 * estrutura de repetição while, responsável por exibir o menu continuamente. A
			 * condição true indica que o laço será infinito, ou seja, continuará em
			 * execução até que ocorra uma instrução de interrupção manual — neste caso,
			 * quando a opção 0 for selecionada.
			 */
			System.out.println(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD_BRIGHT
					+ "••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
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
			 * Construímos a estrutura visual do menu. Os espaços em branco ao redor dos
			 * itens e as linhas vazias foram criados com espaços simples, e não com
			 * tabulações (tecla Tab). Isso garante que a formatação fique uniforme ao ser
			 * exibida no terminal. Antes do conteúdo do comando System.out.println(),
			 * concatenamos as constantes de Cores.TEXT_PURPLE e Cores.ANSI_CYAN_BACKGROUND
			 * definindo que o texto será exibido em rosa, com fundo azul.
			 */

			try { // Início do bloco try, usado para capturar exceções que possam ocorrer durante a leitura da entrada do usuário
				opcao = leia.nextInt(); // Tenta ler um número inteiro digitado pelo usuário e atribuí-lo na variável opcao
				leia.nextLine(); // consome a quebra de linha pendente no buffer do Scanner após a leitura com nextInt(). Isso evita que leituras subsequentes sejam puladas.
			} catch (InputMismatchException e) { // captura a exceção InputMismatchException que ocorre ao digitar um valor que não pode ser interpretado como inteiro, como letras ou símbolos.
				opcao = -1; // Caso a exceção seja lançada, define o valor da variável opcao como -1, indicando que foi feita uma entrada inválida.
				System.out.println(Cores.TEXT_RED + "\nDigite um número entre 0 e 9, conforme as opçoes do menu"); // msg amigável ao usuário, solicitando um número inteiro.
				leia.nextLine(); // Limpa o buffer e descarta um valor inválido para e evitar loop infinito oum erros na próxima leitura
			}

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

				cadastrarConta(); // adicionado no switch apos declaracao do metodo

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Listar Todas as Contas!\n\n");

				listarContas(); // adicionado no switch apos declaracao do metodo

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados de conta - por número!\n\n");
				
				procurarContaPorNumero(); // adicionado no switch apos declaracao do metodo
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados de conta - por titular da conta!\n\n");

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Atualizar dados bancários!\n\n");

				atualizarConta(); // adicionado no switch apos declaracao do metodo

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Deletar a Conta!\n\n");

				deletarConta();
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Saque!\n\n");

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Depósito!\n\n");

				keyPress();
				break;
			case 9:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Transferência entre contas!\n\n");

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opçao inválida! \nPor favor, escolha uma opçao válida.\n\n");

				keyPress();
				break;
			/*
			 * Em todas essas linhas, antes dos comandos System.out.println(), também
			 * adicionamos a constante Cores.TEXT_****_BOLD, garantindo que as mensagens de
			 * cada opção do menu sejam exibidas com destaque.
			 *
			 * Utilizamos a estrutura switch (condicional por casos) para tratar as opções
			 * de 1 a 9. Cada número acionará uma mensagem específica, simulando
			 * funcionalidades futuras. Se a entrada do usuário não corresponder a nenhuma
			 * dessas opções, será exibida a mensagem "Opção Inválida!".
			 * 
			 * Observe que, em todas as opções da estrutura switch-case do menu, foi
			 * adicionada a chamada ao método keyPress(). Essa inclusão garante que, após a
			 * execução de cada ação (como listar, cadastrar, atualizar, etc.), o sistema
			 * aguarde o usuário pressionar a tecla Enter antes de recarregar o menu.
			 */

			}

		}

	}

	// dados exibidos ao selecionada a opcao 0 finalizando o programa
	public static void sobre() {
		System.out.println("\n••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
		System.out.println("Projeto Desenvolvido por: Cintia Marques Dourado                  ");
		System.out.println("Generation Brasil -- CintiaD@genstidents.org   	                   ");
		System.out.println("https://github.com/cdouradom/Conta-Bancaria                   ");
		System.out.println("\n••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
	}

	/*
	 * Declara o método keyPress() como public e static, ou seja, pode ser chamado
	 * diretamente sem a necessidade de instanciar a classe onde está definido. Ele
	 * não retorna nenhum valor (void) e não recebe parâmetros.
	 */
	public static void keyPress() {
		System.out.println(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_UNDERLINED + "\n\nPressione Enter para continuar");
		leia.nextLine();
	}

	private static void criarContasTeste() { //criado o metodo depois de configurar na controller
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 831, 1, "Cintia TESTE CC 1", 500000.00f, 20000.00f));
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 831, 1, "Cintia TESTE CC 2", 700000.00f, 30000.00f));
		contaController.cadastrar(
				new ContaPoupanca(contaController.gerarNumero(), 831, 2, "Cintia TESTE CP 1", 250000.00f, 5));
		contaController.cadastrar(
				new ContaPoupanca(contaController.gerarNumero(), 831, 2, "Cintia TESTE CP 2", 350000.00f, 10));
	}
	
	private static void procurarContaPorNumero() { //criado o metodo depois de configurar na controller
		System.out.print("Digite o numero da conta: ");
			int numero = leia.nextInt();
				leia.nextLine();	
				contaController.procurarPorNumero(numero);
	}

	private static void listarContas() { //criado o metodo depois de configurar na controller
		contaController.listarTodas();
	}

	private static void cadastrarConta() { //criado o metodo depois de configurar na controller

		System.out.print("Digite o número da Agência: ");
		int agencia = leia.nextInt();

		System.out.print("Digite o o nome do Titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.print("Digite o Tipo da conta (1 - CC | 2 - CP): ");
		int tipo = leia.nextInt();

		System.out.print("Digite o Saldo inicial: ");
		float saldo = leia.nextFloat();

		switch (tipo) {
		case 1 -> {
			System.out.print("Digite o Limite inicial: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.print("Digite o dia do aniversário da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido!" + Cores.TEXT_RESET);
		}
	}
	
	private static void atualizarConta() { //criado o metodo depois de configurar na controller
		System.out.print("Digite o número da Conta: ");
		int numero = leia.nextInt();
		leia.nextLine();	

		Conta conta = contaController.buscarNaCollection(numero);
		
		if (conta != null) {
			int agencia = conta.getAgencia();
			String titular = conta.getTitular();
			float saldo = conta.getSaldo();
			int tipo = conta.getTipo();
			
			System.out.printf("Agencia atual: %d \nNova Agencia (pressione enter para manter): ", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada); //converter numero para texto
	
			System.out.printf("Titular atual: %s\nNovo Titular (pressione enter para manter): ", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada;
			
			System.out.printf("Saldo atual: %.2f\nNovo saldo (pressione enter para manter): ", saldo);
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(',', '.'));	
			
		switch (tipo) {
			case 1 -> {
				float limite = ((ContaCorrente) conta).getLimite();
				System.out.printf("Limite atual: R$ %.2f \n Novo limite(pressione enter para manter): ", limite);
				entrada = leia.nextLine();
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada.replace(',', '.'));
				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
			}
			case 2 -> {
				int aniversario = ((ContaPoupanca) conta).getAniversario();
				System.out.printf("Aniversario atual: R$ %d \n Novo aniversario(pressione enter para manter): R$ ", aniversario);
				entrada = leia.nextLine();
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
				contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
				}
				default -> System.out.printf(Cores.TEXT_RED_BOLD + "Tipo de conta inválido!" + Cores.TEXT_RESET);
			}
		} else {System.out.printf("A conta '%d' nao foi encontrada!\n", numero);}
	}
	
	private static void deletarConta() { //criado o metodo depois de configurar na controller
		System.out.print("Digite o número da Conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		System.out.print("Tem certeza que deseja excluir esta conta? (SIM / NAO): ");
		String confirmacao = leia.nextLine();
		
		if (confirmacao.equalsIgnoreCase("Sim")) {
		    contaController.deletar(numero);
		} else if (confirmacao.equalsIgnoreCase("Não")) {
		    System.out.println("\nOperação cancelada!");
		} else { System.out.println("\nOpção inválida! Operação cancelada.");}
	}
}

