package classes;
public class ValorInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
	public ValorInvalidoException() {
		super("Valor inv�lido");
	}
}