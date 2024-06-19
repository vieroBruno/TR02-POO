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
	
	public static int retornarIndex( String cat, String desc ) {
		if( estoque.isEmpty() == false ) {		
			int i;
			for( i=0; i<estoque.size(); i++ ) {	
				EntradaSaidaProduto p = estoque.get(i);
				if( p.getProd().getCategoria().equals(cat) && p.getProd().getDesc().equals(desc) ) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public static boolean confQtde( int index, int qtde ) {
		
		EntradaSaidaProduto prod = estoque.get(index);
		if( prod.getQtde() >= qtde ) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static void altProd( int index, int qtde ) {
		estoque.get(index).setQtde(estoque.get(index).getQtde()-qtde);
	}

	public static void remProd( int index ) {
		estoque.remove(index);
	}
	
}
