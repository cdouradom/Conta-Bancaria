package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository { // nesta etapa, apenas definimos as assinaturas dos métodos na interface ContaRepository, sem implementá-los aqui na repository.

	//Metodos relacionados ao CRUD - que serão implementados na classe ContaController
	
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void procurarPorNumero(int numero);
	public void deletar(int numero);
	public void listarPorTitular(String titular);
	
	//Metodos de operações bancárias - que serão implementados na classe ContaController
	
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);

}