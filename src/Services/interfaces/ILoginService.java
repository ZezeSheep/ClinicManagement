package Services.interfaces;

import model.User;

public interface ILoginService {
	
	// Retorna o objeto User quando as credenciais estiverem corretas e null caso contr�rio.
	User login(String email, String password);
	
	// Cria um novo usu�rio do tipo Cliente no banco de dados.
	void createUser(String email, String password) throws Exception;

	// Retorna um booleano informando se a senha recebida est� de acordo com as regras de neg�cio.
	boolean verifyPasswordRoles(String password);
}
