package conta_bancaria.model;

public class ContaCorrente extends Conta{ // extends puxa da super classe Conta
	
	private float limite; // especifico de CC

	/*
	 *  método construtor 
	 *  adicionado atraves da subclasse ContaPoupanca da linha 3 apos puxar d super classe com o extends Conta
	 */
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	
	/* 
	 * Metodos Get e Set 
	 * permitem acessar e modificar os dados dos atributos a partir de outras classes, sem comprometer a segurança e integridade das informações
	 * >> sao obrigatorios > Source >> Generate Getters and Setters
	*/
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override //indica que estou sobrescrevendo o metodo >> Polimorfismo de Sobreposição (Sobrescrita de Método)
	public boolean sacar(float valor) { 
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;	
	}
	
	@Override //indica que estou sobrescrevendo o metodo >> Polimorfismo de Sobreposição (Sobrescrita de Método)
	public void visualizar() {
		super.visualizar();
		System.out.printf("Limite da Conta: R$ %.2f\n", this.limite);
	}
	
}
