
public class Relatorio {

	public static String gerar_rel_res_estoque() {
		String rel = "Relatório Resumido de Estoque!";
		
		int i, qtde = 0, num = Estoque.getEstoque().size();
		Double valor = 0.0;
		for(i=0;i<num;i++) {
			qtde += Estoque.getEstoque().get(i).getQtde();
			valor += Estoque.getEstoque().get(i).getProd().getPreco() * Estoque.getEstoque().get(i).getQtde();
		}
		rel += "\n\n   Número de Produtos: " + num;
		rel += "\n   Quantidade de Itens: " + qtde;
		rel += "\n   Valor Total em Estoque: R$ " + String.format("%.2f", valor);
		
		return rel;	
	}
	
	public static String[] gerar_rel_det_estoque() {
		int i, num = Estoque.getEstoque().size();
		String[] rels = new String[num];
        for (i = 0; i < num; i++) {
            rels[i] = "Relatório Detalhado de Estoque!";
            rels[i] += "\n\n   Código: " + Estoque.getEstoque().get(i).getProd().getCod();
            rels[i] += "\n   Categoria: " + Estoque.getEstoque().get(i).getProd().getCategoria();
            rels[i] += "\n   Descrição: " + Estoque.getEstoque().get(i).getProd().getDesc();
            rels[i] += "\n   Preço: R$" + String.format("%.2f", Estoque.getEstoque().get(i).getProd().getPreco());
            rels[i] += "\n   Quantidade: " + Estoque.getEstoque().get(i).getQtde();
        }
		
		return rels;
	}
	
	public static String gerar_rel_res_vendas() {
		String rel = "Relatório Resumido de Vendas!";
		
		int i, j, qtde = 0, tam, num = RegVenda.getVenda().size();
		Double valor = 0.0;
		for(i=0;i<num;i++) {
			tam = RegVenda.getVenda().get(i).getVenda().size();
			qtde += tam;
			for(j=0;j<tam;j++) {
				valor += RegVenda.getVenda().get(i).getVenda().get(j).getProd().getPreco()
								* RegVenda.getVenda().get(i).getVenda().get(j).getQtde();
			}
		}
		rel += "\n\n   Número de Vendas: " + num;
		rel += "\n   Quantidade de Produtos Vendidos: " + qtde;
		rel += "\n   Valor Total em Vendas: R$ " + String.format("%.2f", valor);
		
		return rel;	
	}

	public static String[] gerar_rel_det_vendas() {
		int i, j, num = RegVenda.getVenda().size(), qtde = 0;
		double valor = 0.0;
		String[] rels = new String[num];
        for (i = 0; i < num; i++) {
		qtde = 0;
		valor = 0.0;
            rels[i] = "Relatório Detalhado de Vendas!";
            rels[i] += "\n\n   Código da Compra: " + RegVenda.getVenda().get(i).getCod();
            for( j=0; j<RegVenda.getVenda().get(i).getVenda().size(); j++ ) {
            	qtde += RegVenda.getVenda().get(i).getVenda().get(j).getQtde();
            	valor += RegVenda.getVenda().get(i).getVenda().get(j).getProd().getPreco()
            							* RegVenda.getVenda().get(i).getVenda().get(j).getQtde();
            }
            rels[i] += "\n   Quantidade de Itens da Compra: " + qtde;
            rels[i] += "\n   Valor Total da Compra: " + String.format("%.2f", valor);
            rels[i] += "\n   Data da Compra: " + RegVenda.getVenda().get(i).getData();
        }
		
		return rels;
	}
	
}
