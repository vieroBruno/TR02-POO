
public class SaidaProduto {

	private Produto prod;
	private int qtde;
	
	public Produto getProd() {
		return prod;
	}
	public void setProd(Produto prod) {
		this.prod = prod;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
	SaidaProduto( Produto prod, int qtde ) {
		this.prod = prod;
		this.qtde = qtde;
	}
	
}
