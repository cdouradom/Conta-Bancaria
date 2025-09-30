package conta_bancaria.model;

public class ContaPoupanca extends Conta{ // extends puxa da super classe Conta
	
	private int aniversario; // especifico de CP

	/*
	 *  método construtor 
	 *  adicionado atraves da subclasse ContaPoupanca da linha 3 apos puxar d super classe com o extends Conta
	 */
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario; // especifico de CP declarada e acrescentada 
	}

	/* 
	 * Metodos Get e Set 
	 * permitem acessar e modificar os dados dos atributos a partir de outras classes, sem comprometer a segurança e integridade das informações
	 * >> sao obrigatorios > Source >> Generate Getters and Setters
	*/
	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}

	@Override //indica que estou sobrescrevendo o metodo >> Polimorfismo de Sobreposição (Sobrescrita de Método)
	public void visualizar() {
		super.visualizar();
		System.out.printf("Aniversário da conta: %d\n", this.aniversario);
	}
}