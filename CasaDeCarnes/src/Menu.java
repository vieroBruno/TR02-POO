import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Menu {
	
	public static void exibirMenu() {

		int op = 0;
		String[] lista= {"Cadastrar Produto", "Alterar Produto", "Consultar Produto", "Deletar Produto", "Registar Venda", "Gerar Relatório","Sair"};
		JComboBox<String> opcoes = new JComboBox<String>(lista);	
		
		do {
			
			op = EntradaSaidaDados.mostrarCaixaSelecao(opcoes);
			
			switch (op) {		
				case 0:
					cadProd();
					break;
				 case 1:			
					 altProd();
					break;
				 case 2:
					 consProd();
					break;
				case 3: 
					delProd();
					break;
				case 4: 
					regVenda();
					break;
				case 5:		
					gerRel();
					break;
			}			
				
		} while ( op != 6 );
		
	}
	
	public static void cadProd() {
		
		int op = 0;
		String[] categorias = { "Carne Bovina", "Carne Suína", "Carne Avícola", "Carvão", "Cerveja", "Derivados" };
		JComboBox<String> opcoes = new JComboBox<String>(categorias);
		op = EntradaSaidaDados.mostrarCaixaSelecao(opcoes);
		
		String med = null;
		switch (op) {		
			case 0:
			case 1:
			case 2:
			case 3: 
				med = "Kg";
				break;
			case 4:
			case 5:		
				med = "Uni";
				break;
		}	
		
		String desc = EntradaSaidaDados.retornarTexto("Insira a Descrição do Produto:");
		
		Double preco = EntradaSaidaDados.retornarReal("Insira o Valor ( " + med + " ):");
		
		Produto p = new Produto( categorias[op], med, desc, preco );
		
		EntradaSaidaDados.mostrarMensagem(
				"Cod: " + p.getCod() + "\nCategoria: " + p.getCategoria() + "\nDescrição: " + p.getDesc() + "\nValor: R$" + p.getPreco() + p.getUniMed(),
				"Produto");
		
	}
	
	public static void altProd() {
		
	}
	
	public static void consProd() {
		
	}
	public static void delProd() {
		
	}
	public static void regVenda() {
		
	}
	public static void gerRel() {
		
	}
}
