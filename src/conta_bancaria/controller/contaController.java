package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

import conta_bancaria.model.Conta; // importando a classe Conta depois de declarada abaixo
import conta_bancaria.repository.ContaRepository; // importando a classe da interface ContaRepository depois de declarada abaixo
import conta_bancaria.util.Cores;

//classe criada para implementar a interface do repository
public class ContaController implements ContaRepository {
	/*
	 * apos incluir o implements ContaReposiory >> clicar no erro e no link “Add
	 * unimplemented methods” (indicado pela seta vermelha) para gerar
	 * automaticamente todos os métodos da interface.
	 */

	private List<Conta> listaContas = new ArrayList<Conta>();
	/*
	 * Essa lista será responsável por armazenar todas as contas criadas durante a
	 * execução do sistema, funcionando como um banco de dados em memória
	 */
	int numero = 0;
	/*
	 * também declaramos uma variável do tipo int, chamada numero, que será
	 * utilizada para armazenar o número da última conta criada. A cada nova conta
	 * registrada, esse número será incrementado automaticamente, garantindo que
	 * todas as contas possuam numeração sequencial e única.
	 */

	@Override
	public void listarTodas() { // método listarTodas, responsável por exibir todos os objetos da classe Conta armazenados na Collection listaContas
		for (var conta : listaContas) { // utilizamos o laço de repetição for...each para percorrer toda a Collection listaContas
			/*
			 * a variável local conta, utilizada para representar um objeto da classe Conta
			 * a cada iteração, foi declarada com a palavra reservada var O var é uma
			 * palavra-chave introduzida no Java, que permite declarar 'variáveis locais'
			 * com inferência de tipo, ou seja, o compilador determina automaticamente o
			 * tipo da variável com base no valor atribuído no momento da declaração.
			 */
			conta.visualizar();
			/*
			 * responsável por exibir os dados da conta armazenada na variável conta. Esse
			 * método foi definido na classe model Conta e sobrescrito, quando necessário,
			 * nas classes filhas ContaCorrente e ContaPoupanca
			 */
		}
	}

	@Override
	public void cadastrar(Conta conta) { // metodo de cadastrar, e conta eh o intermediador responsavel por gravar o objeto que será adicionado na coleção listaContas
		listaContas.add(conta); // para adicionar o numero da conta na coleção listaContas
		System.out.printf(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD + " A conta %d foi cadastrada com sucesso!\n", conta.getNumero());
		/*
		 * exibe uma mensagem no console indicando que o objeto conta foi adicionado à
		 * coleção listaContas. Para identificar a conta cadastrada, utilizamos o método
		 * getNumero da classe model Conta, que retorna o número da conta, que foi
		 * cadastrada.
		 */

	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
			if (buscaConta != null) {
				listaContas.set(listaContas.indexOf(buscaConta), conta);
				System.out.printf(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD + "A conta '%d' foi atualizada com sucesso!\n", conta.getNumero());
			}else {System.out.printf(Cores.TEXT_PURPLE_UNDERLINED + Cores.ANSI_WHITE_BACKGROUND_BRIGHT + "A conta '%d' nao foi encontrada!\n", numero);}
	}

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
			if (conta != null) {
				conta.visualizar();
			}else {System.out.printf(Cores.TEXT_PURPLE_UNDERLINED + Cores.ANSI_WHITE_BACKGROUND_BRIGHT + "A conta '%d' nao foi encontrada!\n", numero);}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta != null) {
			if(listaContas.remove(conta) == true) {
				System.out.printf(Cores.ANSI_WHITE_BACKGROUND_BRIGHT + Cores.TEXT_PURPLE_BOLD + "A conta '%d' foi DELETADA com sucesso!\n", numero);
			}else {System.out.printf(Cores.TEXT_PURPLE_UNDERLINED + Cores.ANSI_WHITE_BACKGROUND_BRIGHT + "A conta '%d' nao foi encontrada!\n", numero);}
		}
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}

	// Metodos Auxiliares

	public int gerarNumero() { // eh o gerador de conta sequencial automatico
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}