package br.com.bookstore.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.bookstore.compras.GerenciadorVenda;
import br.com.bookstore.compras.ItemVenda;
import br.com.bookstore.compras.bean.ComprasBeanModel;
import br.com.bookstore.compras.bean.PromocaoBeanModel;
import br.com.bookstore.model.livro.Livro;
import br.com.bookstoreExecption.PromocaoException;

@Stateful
@Local(ServiceBookStoreCompra.class)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ServiceBookStoreCompraBean implements ServiceBookStoreCompra {

	@EJB(name="BooKStoreComprasEJB/ComprasBean",beanInterface=ComprasBeanModel.class)
	private ComprasBeanModel comprasEjb;	
	
	@EJB(name="BooKStoreComprasEJB/PromocaoBean",beanInterface=PromocaoBeanModel.class)
	private PromocaoBeanModel promocaoEjb;			
	
	@Override
	public void addItens(Livro livro, Integer qtd) {
		comprasEjb.addItens(livro, qtd);
	}

	@Override
	public void calculaFrete() {
		// TODO Auto-generated method stub
		 comprasEjb.calculaFrete();
	}

	@Override
	public void calcularValorParcial() {
		// TODO Auto-generated method stub
		 comprasEjb.calcularValorParcial();
	}

	@Override
	public void calcularValorTotal() {
		// TODO Auto-generated method stub
		 comprasEjb.calcularValorTotal();
	}

	@Override
	public void editarItens(ItemVenda item, Integer qtd) {
		comprasEjb.editarItens(item, qtd);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void finalzarCompras() {
		comprasEjb.finalzarCompras();
	}

	@Override
	public GerenciadorVenda getCarrinhoCompras() {
		// TODO Auto-generated method stub
		return comprasEjb.getCarrinhoCompras();
	}

	@Override
	public void removeItens(ItemVenda item) {
		comprasEjb.removeItens(item);
	}

	@Override
	@PostConstruct
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void getPromocao() {
		try {
			comprasEjb.setPromocao(promocaoEjb.buscaPromocaoAtiva());
		} catch (PromocaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
