import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JComboBox;

public class Estoque {
	private static ArrayList<EntradaProduto> estoque = new ArrayList<EntradaProduto>();
	
	public static ArrayList<EntradaProduto> getEstoque() {
		return estoque;
	}
	
	public static void addProd(EntradaProduto prod) {
		estoque.add(prod);
	}
	
	public static JComboBox<String> retornarListaCategorias() {
		JComboBox<String> lista = new JComboBox<String>();
		HashSet<String> catAdd = new HashSet<>();
	    
	    if (!estoque.isEmpty()) {
	        for (EntradaProduto p : estoque) {
	            String categoria = p.getProd().getCategoria();
	            if (catAdd.add(categoria)) {
	                lista.addItem(categoria);
	            }
	        }
	    }
		return lista;			
	}
	
	public static JComboBox<String> retornarListaDesc( String cat ) {
		JComboBox<String> lista = new JComboBox<String>();
		if( estoque.isEmpty() == false ) {				
			for( EntradaProduto p : estoque) {	
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
				EntradaProduto p = estoque.get(i);
				if( p.getProd().getCategoria().equals(cat) && p.getProd().getDesc().equals(desc) ) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public static boolean confQtde( int index, int qtde ) {
		
		EntradaProduto prod = estoque.get(index);
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
