import java.text.SimpleDateFormat;
import java.util.Calendar;

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

        EntradaSaidaDados.mostrarMensagem("Produto Cadastrado com Sucesso!", "Cadastrar Produto");
		
	}
	
	public static void altProd() {
		
		if( Estoque.getEstoque().isEmpty() == true ) {	
			
			EntradaSaidaDados.mostrarMensagem("Nenhum Produto Cadastrado!", "Aviso");
			
		} else {
			
			String cat_esc = EntradaSaidaDados.escolherCategoria(Estoque.retornarListaCategorias());
			String desc_esc = EntradaSaidaDados.escolherDesc(Estoque.retornarListaDesc( cat_esc ));
			int index = Estoque.retornarIndex(cat_esc, desc_esc);
			
			EntradaSaidaProduto prodAlt = Estoque.getEstoque().get(index);
			
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
						prodAlt.getProd().setUniMed(med);
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

	        EntradaSaidaDados.mostrarMensagem("Produto Alterado com Sucesso!", "Alterar Produto");
			
		}
		
	}
	
	public static void consProd() {
		
		if( Estoque.getEstoque().isEmpty() == true ) {	
			EntradaSaidaDados.mostrarMensagem("Nenhum Produto Cadastrado!", "Aviso");
		} else {
			String cat_esc = EntradaSaidaDados.escolherCategoria(Estoque.retornarListaCategorias());
			String desc_esc = EntradaSaidaDados.escolherDesc(Estoque.retornarListaDesc( cat_esc ));
			int index = Estoque.retornarIndex(cat_esc, desc_esc);
			
			EntradaSaidaProduto prodAlt = Estoque.getEstoque().get(index);
			
			String dados = "Código: " + prodAlt.getProd().getCod();
			dados += "\nCategoria: " + prodAlt.getProd().getCategoria();
			dados += "\nDescrição: " + prodAlt.getProd().getDesc();
			dados += "\nPreço: R$" + String.format("%.2f", prodAlt.getProd().getPreco()) + " o(a) " + prodAlt.getProd().getUniMed();
			dados += "\nQuantidade: " + prodAlt.getQtde() + " " + prodAlt.getProd().getUniMed() + "(s)";
			
			EntradaSaidaDados.mostrarMensagem(dados, "Consultar Produto");
		}
		
	}
	
	public static void delProd() {
		if( Estoque.getEstoque().isEmpty() == true ) {	
			EntradaSaidaDados.mostrarMensagem("Nenhum Produto Cadastrado!", "Aviso");
		} else {
			
			String cat_esc = EntradaSaidaDados.escolherCategoria(Estoque.retornarListaCategorias());
			String desc_esc = EntradaSaidaDados.escolherDesc(Estoque.retornarListaDesc( cat_esc ));
			int index = Estoque.retornarIndex(cat_esc, desc_esc);
			Estoque.getEstoque().remove(index);

	        EntradaSaidaDados.mostrarMensagem("Produto Deletado com Sucesso!", "Deletar Produto");
				
		}
	}
	
	public static void regVenda() {
		
		if( Estoque.getEstoque().isEmpty() == true ) {	
			
			EntradaSaidaDados.mostrarMensagem("Nenhum Produto para Venda!", "Aviso");
			
		} else {

			Venda v = new Venda();
            boolean fin = false;
            
            while (!fin) {
				
				String cat_esc = EntradaSaidaDados.escolherCategoria(Estoque.retornarListaCategorias());
				String desc_esc = EntradaSaidaDados.escolherDesc(Estoque.retornarListaDesc( cat_esc ));
				int index = Estoque.retornarIndex(cat_esc, desc_esc);
				int qtde = EntradaSaidaDados.retornarInteiro("Insira a Quantidade a ser Vendida:");
				
				EntradaSaidaProduto prod = Estoque.getEstoque().get(index);
				
				while(!Estoque.confQtde(index, qtde)) {
					qtde = EntradaSaidaDados.retornarInteiro("Valor Inválido! Quantidade Máxima - " + 
								prod.getQtde() + " " + prod.getProd().getUniMed() + "(s)\nInsira a Quantidade a ser Vendida:");
				}
				
				SaidaProduto s = new SaidaProduto( prod.getProd(), qtde	);
				v.addProd(s);
				
				if( prod.getQtde() == qtde ) {
					Estoque.remProd(index);
				} else {
					Estoque.altProd(index, qtde);
				}
				
				if( Estoque.getEstoque().isEmpty() == false ) {
					int resp = JOptionPane.showConfirmDialog(null, "Deseja Adicionar mais Produtos?", "Venda",
			                JOptionPane.YES_NO_OPTION);
					if(resp == JOptionPane.NO_OPTION) {
						fin = true;
					}
				} else {
					fin = true;
				}
				
			}
			
            v.setCod(v.getProxCod());
            v.setProxCod(v.getProxCod() + 1);
            
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data = sdf.format(c.getTime());
            v.setData(data);
	        
	        RegVenda.addVenda(v);
	        
	        EntradaSaidaDados.mostrarMensagem("Venda Realizada com Sucesso!", "Registro de Venda");
				
		}
		
	}
	
	public static void gerRel() {

		int op = 0;
		String[] lista= {"Relatório Resumido do Estoque", "Relatório Detalhado do Estoque", "Relatório Resumido de Vendas", "Relatório Detalhado de Vendas", "Sair"};
		JComboBox<String> opcoes = new JComboBox<String>(lista);	
		do {
			
			op = EntradaSaidaDados.mostrarCaixaSelecao(opcoes);
			String rel = null;
			String[] rels = null;
			int i;	
			boolean parou;
			
			Calendar c = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        String data = sdf.format(c.getTime());
			
			switch (op) {
				case 0:
					rel = Relatorio.gerar_rel_res_estoque();
					rel += "\n\nData do Relatório: " + data;
					EntradaSaidaDados.mostrarMensagem(rel, "Gerar Relatório");
					break;
				case 1:
	                rels = Relatorio.gerar_rel_det_estoque();
	                parou = false;
	                for (i = 0; i < rels.length && !parou; i++) {
                        rels[i] += "\n\nData do Relatório: " + data;
                        String[] cont = {"Sair", "Continuar"};
                        int esc = JOptionPane.showOptionDialog(
                            null,
                            rels[i],
                            "Página " + (i+1),
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            cont,
                            cont[0]
                        );
                        if (esc == JOptionPane.YES_OPTION) {
                            parou = true;
                        }
                    }
	                break;
				case 2:
					rel = Relatorio.gerar_rel_res_vendas();
					rel += "\n\nData do Relatório: " + data;
					EntradaSaidaDados.mostrarMensagem(rel, "Gerar Relatório");
					break;
				case 3:
					rels = Relatorio.gerar_rel_det_vendas();
					parou = false;
	                for (i = 0; i < rels.length && !parou; i++) {
                        rels[i] += "\n\nData do Relatório: " + data;
                        String[] cont = {"Sair", "Continuar"};
                        int esc = JOptionPane.showOptionDialog(
                            null,
                            rels[i],
                            "Página " + (i+1),
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            cont,
                            cont[0]
                        );
                        if (esc == JOptionPane.YES_OPTION) {
                            parou = true;
                        }
                    }
					break;
			}
				
		} while ( op != 4 );
		
	}
}
