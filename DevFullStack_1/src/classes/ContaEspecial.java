package classes;

public class ContaEspecial extends Conta{

	public Double limite;

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	protected void temSaldo() {}
	
	public void abrirConta() {}
	
}
