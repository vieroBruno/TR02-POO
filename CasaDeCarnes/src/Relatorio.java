
public class Relatorio {

	public static String gerar_rel_res_estoque() {
		String rel = "Relatório Resumido de Estoque!";
		
		int qtde = 0;
		Double valor = 0.0;
		for( EntradaProduto e : Estoque.getEstoque() ) {
			qtde += e.getQtde();
			valor += e.getProd().getPreco() * e.getQtde();
		}
		rel += "\n\n   Número de Produtos: " + Estoque.getEstoque().size();
		rel += "\n   Quantidade de Itens: " + qtde;
		rel += "\n   Valor Total em Estoque: R$ " + String.format("%.2f", valor);
		
		return rel;	
	}
	
	public static String[] gerar_rel_det_estoque() {
		int cont = 0;
		String[] rels = new String[Estoque.getEstoque().size()];
        for( EntradaProduto e : Estoque.getEstoque() ) {
            rels[cont] = "Relatório Detalhado de Estoque!";
            rels[cont] += "\n\n   Código: " + e.getProd().getCod();
            rels[cont] += "\n   Categoria: " + e.getProd().getCategoria();
            rels[cont] += "\n   Descrição: " + e.getProd().getDesc();
            rels[cont] += "\n   Preço: R$" + String.format("%.2f", e.getProd().getPreco());
            rels[cont] += "\n   Quantidade: " + e.getQtde();
            cont++;
        }
		
		return rels;
	}
	
	public static String gerar_rel_res_vendas() {
		String rel = "Relatório Resumido de Vendas!";
		int qtde = 0;
		Double valor = 0.0;
		for( Venda v : RegVenda.getVenda() ) {
			qtde += v.getProds().size();
			for( SaidaProduto s : v.getProds() ) {
				valor += s.getProd().getPreco() * s.getQtde();
			}
		}
		rel += "\n\n   Número de Vendas: " + RegVenda.getVenda().size();
		rel += "\n   Quantidade de Produtos Vendidos: " + qtde;
		rel += "\n   Valor Total em Vendas: R$ " + String.format("%.2f", valor);
		
		return rel;	
	}

	public static String[] gerar_rel_det_vendas() {
		int cont = 0, qtde = 0;
		double valor = 0.0;
		String[] rels = new String[RegVenda.getVenda().size()];
		for( Venda v : RegVenda.getVenda() ) {
			qtde = 0;
			valor = 0.0;
			rels[cont] = "Relatório Detalhado de Vendas!";
			rels[cont] += "\n\n   Código da Venda: " + v.getCod();
			for( SaidaProduto s : v.getProds() ) {
				qtde += s.getQtde();
				valor += s.getProd().getPreco() * s.getQtde();
			}
			rels[cont] += "\n   Quantidade de Itens da Venda: " + qtde;
			rels[cont] += "\n   Valor Total da Venda: " + String.format("%.2f", valor);
			rels[cont] += "\n   Data da Venda: " + v.getData();
			cont++;
		}
		
		return rels;
	}
	
}
