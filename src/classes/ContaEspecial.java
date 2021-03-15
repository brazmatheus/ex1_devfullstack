package classes;

public class ContaEspecial extends Conta{

	public double limite;
	
	public ContaEspecial(Pessoa cliente, int nrConta, double saldo, double limite) {
		super(cliente, nrConta, saldo);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	protected boolean temSaldo(double valorDebitado) {
		double valorFinal = (this.getSaldo() + this.limite) - valorDebitado;
//		if(valorFinal > 0) {
//			this.sacar(valorDebitado);
//		}
		return valorFinal > 0;
	}
	
	public void abrirConta() {}
	
}
