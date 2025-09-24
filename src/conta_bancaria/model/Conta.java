package conta_bancaria.model;

public class Conta {

	// Atributos da Classe
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	// Metodo Construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	// Metodos Get e Set -- sao obrigatorios -- Source > Generate Getters and Setters
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
	}

	public boolean sacar(float valor) {
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
		System.out.println("\n**********************************");
		System.out.println("\nDados da Conta");
		System.out.printf("\nNumero da Conta: %d", this.numero);
		System.out.printf("\nNumero da Agencia: %d", this.agencia);
		System.out.printf("\ntipo da Conta: %s", tipo);
		System.out.printf("\nTitular da Conta: %s", this.titular);
		System.out.printf("\nSaldo da Conta: %.2f", this.saldo);

	}

}
