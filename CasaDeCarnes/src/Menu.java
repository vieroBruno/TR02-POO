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
				med = "Kg";
				break;
			case 3: 
			case 4:
			case 5:		
				med = "Uni";
				break;
		}	
		
		String desc = EntradaSaidaDados.retornarTexto("Insira a Descrição do Produto:");
		
		boolean existe = false;
		if( Estoque.getEstoque().isEmpty() == false ) {	
			for(EntradaSaidaProduto prod : Estoque.getEstoque()) {
				if( prod.getProd().getCategoria().equals(categorias[op]) && prod.getProd().getDesc().equals(desc) ) {
					existe = true;
					break;
				}
			}
		}
		
		if( existe ) {
			EntradaSaidaDados.mostrarMensagem("Produto já Cadastrado!", "Aviso");
		} else {
			Double preco = EntradaSaidaDados.retornarReal("Insira o Valor ( " + med + " ):");
			int qtde = EntradaSaidaDados.retornarInteiro("Insira a Quantidade em " + med + ":");
			
			Produto p = new Produto( categorias[op], med, desc, preco );
			EntradaSaidaProduto ep = new EntradaSaidaProduto( p, qtde );
			Estoque.addProd(ep);
		}
		
	}
	
	public static void altProd() {
		
		if( Estoque.getEstoque().isEmpty() == true ) {	
			
			EntradaSaidaDados.mostrarMensagem("Nenhum Produto Cadastrado!", "Aviso");
			
		} else {
			
			String cat_esc = EntradaSaidaDados.escolherCategoria(Estoque.retornarListaCategorias());
			String desc_esc = EntradaSaidaDados.escolherDesc(Estoque.retornarListaDesc( cat_esc ));
			int cod = Estoque.retornarCodigo(cat_esc, desc_esc);
			
			EntradaSaidaProduto prodAlt = Estoque.getEstoque().get(cod-1);
			
			int op = 0;
			String[] lista= {"Categoria", "Descrição", "Preço", "Quantidade","Salvar"};
			JComboBox<String> opcoes = new JComboBox<String>(lista);	
			
			do {
				
				op = EntradaSaidaDados.mostrarCaixaSelecao(opcoes);
				
				switch (op) {		
					case 0:
						int op_cat = 0;
						String[] categorias = { "Carne Bovina", "Carne Suína", "Carne Avícola", "Carvão", "Cerveja", "Derivados" };
						JComboBox<String> opcoes_cat = new JComboBox<String>(categorias);
						op_cat = EntradaSaidaDados.mostrarCaixaSelecao(opcoes_cat);
						
						String med = null;
						switch (op_cat) {		
							case 0:
							case 1:
							case 2:
								med = "Kg";
								break;
							case 3: 
							case 4:
							case 5:		
								med = "Uni";
								break;
						}	
						
						prodAlt.getProd().setCategoria( categorias[op_cat] );
						prodAlt.getProd().setUniMed(med);;
						break;
					 case 1:			
						 prodAlt.getProd().setDesc( EntradaSaidaDados.retornarTexto("Insira a Descrição do Produto:") );
						break;
					 case 2:
						 prodAlt.getProd().setPreco( EntradaSaidaDados.retornarReal("Insira o Valor ( " + prodAlt.getProd().getUniMed() + " ):") );
						break;
					case 3: 
						prodAlt.setQtde( EntradaSaidaDados.retornarInteiro("Insira a Quantidade ( " + prodAlt.getProd().getUniMed() + " ):") );
						break;
				}			
					
			} while ( op != 4 );
			
		}
		
	}
	
	public static void consProd() {
		
		String cat_esc = EntradaSaidaDados.escolherCategoria(Estoque.retornarListaCategorias());
		String desc_esc = EntradaSaidaDados.escolherDesc(Estoque.retornarListaDesc( cat_esc ));
		int cod = Estoque.retornarCodigo(cat_esc, desc_esc);

		EntradaSaidaDados.mostrarMensagem("Código: " + cod, "Teste");
		
		EntradaSaidaProduto prodAlt = Estoque.getEstoque().get(cod-1);
		
		String dados = "Código: " + prodAlt.getProd().getCod();
		dados += "\nCategoria: " + prodAlt.getProd().getCategoria();
		dados += "\nDescrição: " + prodAlt.getProd().getDesc();
		dados += "\nPreço: R$" + prodAlt.getProd().getPreco() + " o(a) " + prodAlt.getProd().getUniMed();
		dados += "\nQuantidade: " + prodAlt.getQtde() + " " + prodAlt.getProd().getUniMed() + "(s)";
		
		EntradaSaidaDados.mostrarMensagem(dados, "Consultar Produto");
		
	}
	
	public static void delProd() {
		
	}
	
	public static void regVenda() {
		
	}
	
	public static void gerRel() {
		
	}
}
