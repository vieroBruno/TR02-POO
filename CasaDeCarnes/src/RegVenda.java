import java.util.ArrayList;

public class RegVenda {

	private static ArrayList<Venda> registros = new ArrayList<Venda>();
	
	public static ArrayList<Venda> getVenda() {
		return registros;
	}
	public static void addVenda(Venda venda) {
		registros.add(venda);
	}
}
