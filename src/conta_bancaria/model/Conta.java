package conta_bancaria.model;

public abstract class Conta {

	/*
 	* variáveis que representam os atributos da classe Conta
	* utilizam o modificador de acesso private, significa que só podem ser acessados diretamente dentro da própria classe
	* ficam protegidos e só podem ser acessados ou modificados por meio de métodos públicos, 
	* que são os métodos get (para leitura) e set (para alteração)
	*/
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	/* Metodo Construtor 
	* Polimorfismo de Sobrecarga (Sobrecarga de Método) 
	* >> sao obrigatorios > Source >> Generate Constructor using Fields
	*/
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	} // utilizamos a palavra-chave this para referenciar os atributos da instância atual da classe, evitando ambiguidade.

	/* 
	 * Metodos Get e Set 
	 * permitem acessar e modificar os dados dos atributos a partir de outras classes, sem comprometer a segurança e integridade das informações
	 * >> sao obrigatorios > Source >> Generate Getters and Setters
	*/
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	} // sest com o tipo void, pois não retornam nenhum valor

	/*
	 * Métodos Auxiliares
	 */
	public boolean sacar(float valor) { //O método sacar(float valor) realiza uma verificação para garantir que o valor solicitado não seja maior que o saldo disponível.
		if(this.saldo < valor) {
			System.out.println("Saldo insuficiente para o saque enviado");
			return false;
		}
		this.saldo = this.saldo - valor;
			return true;
	}
	
	public void depositar(float valor) {
		this.saldo = this.saldo + valor;
	}
	
	public void visualizar() {

		String tipo = "\n ";

		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		default -> tipo = "Desconhecido";
		}
		
		System.out.println("\n••••••••••••••••••••••••••••••••••••");
		System.out.println("\nDados da Conta");
		System.out.printf("\nNumero da Conta: %d", this.numero);
		System.out.printf("\nNumero da Agencia: %d", this.agencia);
		System.out.printf("\ntipo da Conta: %s", tipo);
		System.out.printf("\nTitular da Conta: %s", this.titular);
		System.out.printf("\nSaldo da Conta: R$ %.2f\n", this.saldo);

	}

}
