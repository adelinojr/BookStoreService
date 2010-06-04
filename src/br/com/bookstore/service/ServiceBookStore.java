package br.com.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import br.com.bookstore.cliente.Usuario;
import br.com.bookstore.compras.PromocaoVendas;
import br.com.bookstore.exceptions.ClienteException;
import br.com.bookstore.model.exceptions.LivroException;
import br.com.bookstore.model.livro.Livro;
import br.com.bookstoreExecption.PromocaoException;

public interface ServiceBookStore {

	/**
	 * Realiza o cadastro de um novo cliente. O cadastro n�o deve ser permitido
	 * caso o cliente esteja marcado com o perfil de administrador. Da mesma forma,
	 * o cadastro tamb�m n�o deve ser permitido caso j� exista um cliente com o mesmo
	 * CPF cadastrado na base de dados da aplica��o.
	 * 
	 * @param cliente o Cliente a ser cadastrado.
	 * @throws ClienteException Caso o cliente a ser cadastrado j� exista na base de dados, possua alguma
	 * 							informa��o inv�lida, ou esteja com o perfil de administrador configurado.
	 */
	public void cadastrarCliente( Usuario cliente ) throws ClienteException;
	
	/**
	 * Exclui um cliente da base de dados da aplica��o. N�o deve ser poss�vel, via aplica��o,
	 * remover um usu�rio, cujo perfil seja administrador. 
	 * 
	 * @param cliente O cliente a ser removido
	 * @throws ClienteException Caso o cliente a ser removido n�o exista, ou possua o perfil de administrador.
	 */
	public void removerCliente( Usuario cliente ) throws ClienteException;
	
	/**
	 * Permite modificar as informa��es cadastrais de um cliente. N�o deve ser poss�vel alterar o CPF
	 * do cliente, nem mudar o seu perfil. As informa��es atuais do cliente ser�o subistitu�das pelas 
	 * informa��es fornecidas atrav�s do objeto passado como par�metro.
	 * 
	 * @param cliente O cliente cujas informa��es ser�o modificadas.
	 * @throws ClienteException Caso existam restri��es nos dados fornecidos atrav�s do novo objeto passado
	 * 							como par�metro ou o cliente a ser modificado n�o exista nas bases de dados.
	 */
	public void editarCliente( Usuario cliente ) throws ClienteException;
	
	/**
	 * Obt�m uma lista com todos os clientes cadastrados na aplica��o. Esta lista n�o deve conter usu�rios
	 * marcados como administradores.
	 * 
	 * @return Uma lista com todos os clientes cadastrados, ou uma lista vazia, caso n�o exista nenhum
	 * 			cliente cadastrado.
	 */
	public List<Usuario> listarClientes();

	/**
	 * Obt�m o cliente representado pelo CPF passado como par�metro. Usu�rios que possuem o perfil
	 * de administrador n�o s�o vis�veis a esta chamada.
	 * 
	 * @param cpf o CPF usado para recuperar o cliente espec�fico.
	 * @return o cliente cujo CPF foi passado como par�metro, ou null, caso n�o exista cliente cadastrado
	 * 			com o CPF em quest�o.
	 */
	public Usuario obterCliente( String cpf ) throws ClienteException ; 
	
	/**
	 * Obt�m uma lista com todos os estados reconhecidos pela aplica��o.
	 * @return Uma lista com os estados em formato String.
	 */
	public List<String> obterTodosOsEstados();
	
	/**
	 * Obt�m todas as cidades referentes ao estado passado como par�metro.
	 * @param estado o estado para o qual estamos procurando a cidade.
	 * @return O conjunto de cidades referentes ao estado, ou uma lista vazia, 
	 * 			caso n�o haja cidades cadastradas.
	 */
	public List<String> obterCidades( String estado );
	
	
	/**
	 * Realiza o cadastro de um novo Livro.
	 * 
	 * @param livro o livro a ser cadastrado.
	 * @throws LivroException Caso o livro a ser cadastrado j� exista na base de dados ou possua alguma
	 * 							informa��o inv�lida..
	 */
	public void cadastrarLivro( Livro livro ) throws LivroException;
	
	/**
	 * Exclui um livro da base de dados da aplica��o.
	 * 
	 * @param livro O Livro a ser removido
	 * @throws LivroException Caso o livro a ser removido n�o exista.
	 */
	public void removerLivro( Livro livro ) throws LivroException;
	
	/**
	 * Permite modificar as informa��es cadastrais de um livro. N�o deve ser poss�vel alterar o ISBN
	 * do livro. As informa��es atuais do livro existente na base de dados ser�o subistitu�das pelas 
	 * informa��es fornecidas atrav�s do objeto passado como par�metro.
	 * 
	 * @param livro O livro cujas informa��es ser�o modificadas.
	 * @throws LivroException Caso existam restri��es nos dados fornecidos atrav�s do novo objeto passado
	 * 							como par�metro ou o livro a ser modificado n�o exista nas bases de dados.
	 */
	public void editarLivro( Livro livro ) throws LivroException;
	
	/**
	 * Obt�m uma lista com todos os livros cadastrados na aplica��o.
	 * 
	 * @return Uma lista com todos os livros cadastrados, ou uma lista vazia, caso n�o exista nenhum
	 * 			livro cadastrado.
	 */
	public List<Livro> listarLivros();

	/**
	 * Obt�m o livro representado pelo ISBN passado como par�metro. 
	 * 
	 * @param isbn o ISBN usado para recuperar o livro espec�fico.
	 * @return o livro cujo ISBN foi passado como par�metro, ou null, caso n�o exista livro cadastrado
	 * 			com o ISBN em quest�o.
	 * @throws LivroException 
	 */
	public Livro obterLivro( String isbn ) throws LivroException;
	
	
	public ArrayList<Livro> buscaLivro(String dado) throws LivroException;	
	
	public void removePromocao(PromocaoVendas promocao) throws PromocaoException;
	public void editaPromocao(PromocaoVendas promocao) throws PromocaoException;
	public void cadastraPromocao(PromocaoVendas promocao) throws PromocaoException;
	public ArrayList<PromocaoVendas> buscaTodasPromocao();
	public PromocaoVendas buscaPromocaoAtiva() throws PromocaoException;	
}
