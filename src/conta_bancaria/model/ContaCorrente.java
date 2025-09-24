package conta_bancaria.model;

public class ContaCorrente extends Conta{
	
	private float limite;
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
		
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override //indica que estou sobrescrevendo o metodo
	public boolean sacar(float valor) { 
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;	
	}
	
	@Override //indica que estou sobrescrevendo o metodo
	public void visualizar() {
		super.visualizar();
		System.out.printf("\nLimite da Conta: R$ %.2f\n", this.limite);
	}
	
}
