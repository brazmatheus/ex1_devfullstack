package classes;

public class ContaPoupanca extends Conta{

	private double txCorrecao;
	
	public ContaPoupanca(Pessoa cliente, int nrConta, double saldo, double txCorrecao) {
		super(cliente, nrConta, saldo);
		this.txCorrecao = txCorrecao;
	}
	
	public ContaPoupanca() {

	}

	public double getTxCorrecao() {
		return txCorrecao;
	}

	public void setTxCorrecao(double txCorrecao) {
		this.txCorrecao = txCorrecao;
	}
	
	public void atualizaSaldoRendimento(){}
	
	public void abrirConta() {}
}
