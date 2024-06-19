import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaidaDados {
	
	public static void mostrarMensagem( String msg, String cab ) {
		JOptionPane.showMessageDialog( null, msg, cab, 1 );
	}
	
	
	public static int mostrarCaixaSelecao( JComboBox<String> opcoes ) {
		JOptionPane.showMessageDialog( null, opcoes, "Selecione uma Opção:", 1 );
		return opcoes.getSelectedIndex();
	}
	
	public static String retornarTexto( String msg ) {
		return JOptionPane.showInputDialog( null, msg, "Inserção de Valores", 1 );
	}
	
	public static int retornarInteiro( String msg ) {
		return Integer.parseInt(JOptionPane.showInputDialog( null, msg, "Inserção de Valores", 1 ));
	}
	
	public static double retornarReal( String msg ) {		
		return Double.parseDouble(JOptionPane.showInputDialog( null, msg, "Inserção de Valores", 1 ));
	}
	
	public static String escolherCategoria(JComboBox<String> listaCategoria) {
		JOptionPane.showInternalMessageDialog(null, listaCategoria, "Lista de Categorias", 1, null);
		return (String)listaCategoria.getSelectedItem();
	}
	
	public static String escolherDesc(JComboBox<String> listaDesc) {
		JOptionPane.showInternalMessageDialog(null, listaDesc, "Lista das Descrições", 1, null);
		return (String)listaDesc.getSelectedItem();
	}

}