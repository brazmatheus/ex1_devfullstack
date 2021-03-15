package classes;

public class Conta {

	private Pessoa cliente;
	private int nrConta;
	private double saldo;
	
	public Conta(Pessoa cliente, int nrConta, double saldo){
		this.cliente = cliente;
		this.nrConta = nrConta;
		this.saldo = saldo;
	}
	
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public int getNrConta() {
		return nrConta;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public void abrirConta() {}
	
	public void sacar(double valor) {
		if(this.temSaldo(valor)) {
			this.saldo = this.saldo - valor;	
		}
	}
	
	private void debitar(double valor) {
		this.saldo = this.saldo - valor;
	}
	
	protected boolean temSaldo(double valorDebitado) {
		return this.saldo - valorDebitado >= 0;
	}
	
	public void depositar(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	public void transferir(double valorDebitado, Conta contaRemetente, Conta contaDestinatario) {
		if(contaRemetente.temSaldo(valorDebitado)) {
			contaRemetente.debitar(valorDebitado);
			contaDestinatario.depositar(valorDebitado);
		}
	}
		
}
