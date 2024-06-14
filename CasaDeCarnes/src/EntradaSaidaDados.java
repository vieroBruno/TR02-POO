import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaidaDados {
	
	public static void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public static String retornarTexto(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);
	}
	
	public static int retornarInteiro(String mensagem) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
	}
	
	public static double retornarReal(String mensagem) {		
		return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
	}
	
	public static int escolherProduto(JComboBox<String> listaProduto) {
		JOptionPane.showInternalMessageDialog(null, listaProduto, "Lista de produtos", 1, null);
		return listaProduto.getSelectedIndex();
	}

}