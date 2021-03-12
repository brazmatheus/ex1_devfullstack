package classes;

public class Conta {

	public Pessoa cliente;
	public int nrConta;
	public Double saldo;
	
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public int getNrConta() {
		return nrConta;
	}
	public Double getSaldo() {
		return saldo;
	}
	
	public void abrirConta() {}
	
	public void sacar() {}
	
	private void debitar() {}
	
	protected void temSaldo() {}
	
	public void depositar() {}
	
	public void transferir() {}
		
}
