import java.util.ArrayList;

import javax.swing.JComboBox;

public class Estoque {
	private static ArrayList<EntradaSaidaProduto> estoque = new ArrayList<EntradaSaidaProduto>();
	
	public static ArrayList<EntradaSaidaProduto> getEstoque() {
		return estoque;
	}
	
	public static void addProd(EntradaSaidaProduto prod) {
		estoque.add(prod);
	}
	
	public static JComboBox<String> retornarListaCategorias() {
		JComboBox<String> lista = new JComboBox<String>();
		if( estoque.isEmpty() == false ) {				
			for( EntradaSaidaProduto p : estoque) {			
				lista.addItem( p.getProd().getCategoria() );
			}
		}
		return lista;			
	}
	
	public static JComboBox<String> retornarListaDesc( String cat ) {
		JComboBox<String> lista = new JComboBox<String>();
		if( estoque.isEmpty() == false ) {				
			for( EntradaSaidaProduto p : estoque) {	
				if( p.getProd().getCategoria().equals(cat) ) {
					lista.addItem( p.getProd().getDesc() );
				}
			}
		}
		return lista;			
	}
	
	public static int retornarCodigo( String cat, String desc ) {
		int cod = 0;
		
		if( estoque.isEmpty() == false ) {				
			for( EntradaSaidaProduto p : estoque) {	
				if( p.getProd().getCategoria().equals(cat) && p.getProd().getDesc().equals(desc) ) {
					cod = p.getProd().getCod();
					break;
				}
			}
		}
		
		return cod;
	}
	
	public static void confProd() {
		
	}
	public static void altProd() {
		
	}

	public static void remProd() {
		
	}
	
}
