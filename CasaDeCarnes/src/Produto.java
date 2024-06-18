
public class Produto {

	private int proxCod = 1;
	private int cod;
	private String categoria;
	private String uniMed;
	private String desc;
	private double preco;
	
	public int getProxCod() {
		return proxCod;
	}
	public void setProxCod(int proxCod) {
		this.proxCod = proxCod;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getUniMed() {
		return uniMed;
	}
	public void setUniMed(String uniMed) {
		this.uniMed = uniMed;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	Produto ( String categoria, String med, String desc, Double preco ) {
		this.cod = this.proxCod;
		this.proxCod++;
		this.categoria = categoria;
		this.uniMed = med;
		this.desc = desc;
		this.preco = preco;
	}

}
