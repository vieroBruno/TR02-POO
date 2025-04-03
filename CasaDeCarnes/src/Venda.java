import java.util.ArrayList;

public class Venda {
	
	private static int proxCod = 1;
	private int cod;
	private static ArrayList<SaidaProduto> venda = new ArrayList<SaidaProduto>();
	private String data;
	
	public int getProxCod() {
		return proxCod;
	}
	public void setProxCod(int proxCod) {
		Venda.proxCod = proxCod;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public ArrayList<SaidaProduto> getProds() {
		return venda;
	}
	public static void setVenda(ArrayList<SaidaProduto> venda) {
		Venda.venda = venda;
	}
	public void addProd(SaidaProduto prod) {
		venda.add(prod);
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
