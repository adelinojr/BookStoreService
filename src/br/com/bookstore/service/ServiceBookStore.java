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
	 * Realiza o cadastro de um novo cliente. O cadastro não deve ser permitido
	 * caso o cliente esteja marcado com o perfil de administrador. Da mesma forma,
	 * o cadastro também não deve ser permitido caso já exista um cliente com o mesmo
	 * CPF cadastrado na base de dados da aplicação.
	 * 
	 * @param cliente o Cliente a ser cadastrado.
	 * @throws ClienteException Caso o cliente a ser cadastrado já exista na base de dados, possua alguma
	 * 							informação inválida, ou esteja com o perfil de administrador configurado.
	 */
	public void cadastrarCliente( Usuario cliente ) throws ClienteException;
	
	/**
	 * Exclui um cliente da base de dados da aplicação. Não deve ser possível, via aplicação,
	 * remover um usuário, cujo perfil seja administrador. 
	 * 
	 * @param cliente O cliente a ser removido
	 * @throws ClienteException Caso o cliente a ser removido não exista, ou possua o perfil de administrador.
	 */
	public void removerCliente( Usuario cliente ) throws ClienteException;
	
	/**
	 * Permite modificar as informações cadastrais de um cliente. Não deve ser possível alterar o CPF
	 * do cliente, nem mudar o seu perfil. As informações atuais do cliente serão subistituídas pelas 
	 * informações fornecidas através do objeto passado como parâmetro.
	 * 
	 * @param cliente O cliente cujas informações serão modificadas.
	 * @throws ClienteException Caso existam restrições nos dados fornecidos através do novo objeto passado
	 * 							como parâmetro ou o cliente a ser modificado não exista nas bases de dados.
	 */
	public void editarCliente( Usuario cliente ) throws ClienteException;
	
	/**
	 * Obtém uma lista com todos os clientes cadastrados na aplicação. Esta lista não deve conter usuários
	 * marcados como administradores.
	 * 
	 * @return Uma lista com todos os clientes cadastrados, ou uma lista vazia, caso não exista nenhum
	 * 			cliente cadastrado.
	 */
	public List<Usuario> listarClientes();

	/**
	 * Obtém o cliente representado pelo CPF passado como parâmetro. Usuários que possuem o perfil
	 * de administrador não são visíveis a esta chamada.
	 * 
	 * @param cpf o CPF usado para recuperar o cliente específico.
	 * @return o cliente cujo CPF foi passado como parâmetro, ou null, caso não exista cliente cadastrado
	 * 			com o CPF em questão.
	 */
	public Usuario obterCliente( String cpf ) throws ClienteException ; 
	
	/**
	 * Obtém uma lista com todos os estados reconhecidos pela aplicação.
	 * @return Uma lista com os estados em formato String.
	 */
	public List<String> obterTodosOsEstados();
	
	/**
	 * Obtém todas as cidades referentes ao estado passado como parâmetro.
	 * @param estado o estado para o qual estamos procurando a cidade.
	 * @return O conjunto de cidades referentes ao estado, ou uma lista vazia, 
	 * 			caso não haja cidades cadastradas.
	 */
	public List<String> obterCidades( String estado );
	
	
	/**
	 * Realiza o cadastro de um novo Livro.
	 * 
	 * @param livro o livro a ser cadastrado.
	 * @throws LivroException Caso o livro a ser cadastrado já exista na base de dados ou possua alguma
	 * 							informação inválida..
	 */
	public void cadastrarLivro( Livro livro ) throws LivroException;
	
	/**
	 * Exclui um livro da base de dados da aplicação.
	 * 
	 * @param livro O Livro a ser removido
	 * @throws LivroException Caso o livro a ser removido não exista.
	 */
	public void removerLivro( Livro livro ) throws LivroException;
	
	/**
	 * Permite modificar as informações cadastrais de um livro. Não deve ser possível alterar o ISBN
	 * do livro. As informações atuais do livro existente na base de dados serão subistituídas pelas 
	 * informações fornecidas através do objeto passado como parâmetro.
	 * 
	 * @param livro O livro cujas informações serão modificadas.
	 * @throws LivroException Caso existam restrições nos dados fornecidos através do novo objeto passado
	 * 							como parâmetro ou o livro a ser modificado não exista nas bases de dados.
	 */
	public void editarLivro( Livro livro ) throws LivroException;
	
	/**
	 * Obtém uma lista com todos os livros cadastrados na aplicação.
	 * 
	 * @return Uma lista com todos os livros cadastrados, ou uma lista vazia, caso não exista nenhum
	 * 			livro cadastrado.
	 */
	public List<Livro> listarLivros();

	/**
	 * Obtém o livro representado pelo ISBN passado como parâmetro. 
	 * 
	 * @param isbn o ISBN usado para recuperar o livro específico.
	 * @return o livro cujo ISBN foi passado como parâmetro, ou null, caso não exista livro cadastrado
	 * 			com o ISBN em questão.
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
