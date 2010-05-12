package br.com.bookstore.service;

import java.util.List;

import br.com.bookstore.cliente.Usuario;
import br.com.bookstore.exceptions.ClienteException;

public interface ServiceStoreCliente {


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
}
