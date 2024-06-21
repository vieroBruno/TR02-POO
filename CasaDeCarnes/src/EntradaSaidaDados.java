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
		try {
			String input = JOptionPane.showInputDialog( null, msg, "Inserção de Valores", 1 );
			processString(input);
			return input;
		}catch(IllegalArgumentException  e) {
			mostrarMensagem(e.getMessage(),"Erro!");
			return "";
		}
	}
	
	public static int retornarInteiro( String msg ) {
		try {
			return Integer.parseInt(JOptionPane.showInputDialog( null, msg, "Inserção de Valores", 1 ));
		}catch(NumberFormatException e) {
			mostrarMensagem("A operação não pode ser realizada pois um caractere inválido foi digitado","Erro!");
			return 0;
		}
	}
	
	public static double retornarReal( String msg ) {
		try {
			return Double.parseDouble(JOptionPane.showInputDialog( null, msg, "Inserção de Valores", 1 ));
		}catch(NumberFormatException e) {
			mostrarMensagem("A operação não pode ser realizada pois um caractere inválido foi digitado","Erro!");
			return 0; 
		}catch(NullPointerException e) {
			mostrarMensagem("Informação não pode ser nulo","Erro!");
			return 0;
		}
	}
	
	public static String escolherCategoria(JComboBox<String> listaCategoria) {
		JOptionPane.showInternalMessageDialog(null, listaCategoria, "Lista de Categorias", 1, null);
		return (String)listaCategoria.getSelectedItem();
	}
	
	public static String escolherDesc(JComboBox<String> listaDesc) {
		JOptionPane.showInternalMessageDialog(null, listaDesc, "Lista das Descrições", 1, null);
		return (String)listaDesc.getSelectedItem();
	}
	
	public static void processString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("A string não pode ser vazia ou nula.");
        }
        
    }

}