package br.com.bookstore.service;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;


import br.com.bookstore.bean.ClienteBeanModel;
import br.com.bookstore.bean.LivroBeanModel;
import br.com.bookstore.cliente.Usuario;
import br.com.bookstore.compras.PromocaoVendas;
import br.com.bookstore.compras.bean.PromocaoBeanModel;
import br.com.bookstore.exceptions.ClienteException;
import br.com.bookstore.model.exceptions.LivroException;
import br.com.bookstore.model.livro.Livro;
import br.com.bookstoreExecption.PromocaoException;

@Stateless
@Local(ServiceBookStore.class)
public class ServiceBookStoreBean implements  ServiceBookStore{
	
	@EJB(name="BookStoreLivroEJB/LivroBeanGen",beanInterface=LivroBeanModel.class)
	private LivroBeanModel livroEjb;
	
	@EJB(name="BookStoreClienteEJB/ClienteBeanGen",beanInterface=ClienteBeanModel.class)
	private ClienteBeanModel clienteEjb;	
	
	@EJB(name="BooKStoreComprasEJB/PromocaoBean",beanInterface=PromocaoBeanModel.class)
	private PromocaoBeanModel promocaoEjb;		
	
	@Override
	public void cadastrarCliente(Usuario cliente) throws ClienteException {
		clienteEjb.cadastrarCliente(cliente);
		
	}

	@Override
	public void editarCliente(Usuario cliente) throws ClienteException {
		clienteEjb.editarCliente(cliente);
		
	}

	@Override
	public List<Usuario> listarClientes() {
		return clienteEjb.listarClientes();
	}

	@Override
	public List<String> obterCidades(String estado) {
		// TODO Auto-generated method stub
		return clienteEjb.obterCidades(estado);
	}

	@Override
	public Usuario obterCliente(String cpf) throws ClienteException {
		// TODO Auto-generated method stub
		return clienteEjb.obterCliente(cpf);
	}

	@Override
	public List<String> obterTodosOsEstados() {
		// TODO Auto-generated method stub
		return clienteEjb.obterTodosOsEstados();
	}

	@Override
	public void removerCliente(Usuario cliente) throws ClienteException {
		clienteEjb.removerCliente(cliente);
		
	}

	@Override
	public ArrayList<Livro> buscaLivro(String dado) throws LivroException {
		// TODO Auto-generated method stub
		return livroEjb.buscaLivro(dado);
	}

	@Override
	public void cadastrarLivro(Livro livro) throws LivroException {
		livroEjb.cadastrarLivro(livro);
		
	}

	@Override
	public void editarLivro(Livro livro) throws LivroException {
		livroEjb.editarLivro(livro);
		
	}

	@Override
	public List<Livro> listarLivros() {
		// TODO Auto-generated method stub
		return livroEjb.listarLivros();
	}

	@Override
	public Livro obterLivro(String isbn) throws LivroException {
		// TODO Auto-generated method stub
		return livroEjb.obterLivro(isbn);
	}

	@Override
	public void removerLivro(Livro livro) throws LivroException {
		livroEjb.removerLivro(livro);
		
	}

	@Override
	public PromocaoVendas buscaPromocaoAtiva() throws PromocaoException {
		// TODO Auto-generated method stub
		return promocaoEjb.buscaPromocaoAtiva();
	}

	@Override
	public ArrayList<PromocaoVendas> buscaTodasPromocao() {
		// TODO Auto-generated method stub
		return promocaoEjb.buscaTodasPromocao();
	}

	@Override
	public void cadastraPromocao(PromocaoVendas promocao)
			throws PromocaoException {
		promocaoEjb.cadastraPromocao(promocao);
		
	}

	@Override
	public void editaPromocao(PromocaoVendas promocao) throws PromocaoException {
		promocaoEjb.editaPromocao(promocao);
		
	}

	@Override
	public void removePromocao(PromocaoVendas promocao)
			throws PromocaoException {
		promocaoEjb.removePromocao(promocao);
		
	}



}
