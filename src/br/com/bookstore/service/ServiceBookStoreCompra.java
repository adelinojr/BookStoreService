package br.com.bookstore.service;

import br.com.bookstore.compras.GerenciadorVenda;
import br.com.bookstore.compras.ItemVenda;
import br.com.bookstore.model.livro.Livro;

public interface ServiceBookStoreCompra {

	public void addItens(Livro livro, Integer qtd);
	
	public void removeItens(ItemVenda item);
	
	public void calculaFrete();
	
	public void calcularValorTotal();
	
	public void calcularValorParcial();
	
	public GerenciadorVenda getCarrinhoCompras();
	
	public void editarItens(ItemVenda item, Integer qtd);
	
	public void finalzarCompras();
	
	public void getPromocao();
}
