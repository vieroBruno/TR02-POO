
public class Principal {
	public static void main(String[] args) {
		
		Produto p1 = new Produto( "Carne Bovina", "Kg", "Picanha", 99.9 );
		EntradaProduto ep1 = new EntradaProduto( p1, 20 );
		Produto p2 = new Produto( "Cerveja", "Uni", "Heineken", 10.0 );
		EntradaProduto ep2 = new EntradaProduto( p2, 50 );
		Estoque.addProd(ep1);
		Estoque.addProd(ep2);
		
		Menu.exibirMenu(); 
	}
}
