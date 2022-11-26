package Services.interfaces;

import model.User;

public interface ILoginService {
	
	// Retorna o objeto User quando as credenciais estiverem corretas e null caso contrário.
	User login(String email, String password);
	
	// Cria um novo usuário do tipo Cliente no banco de dados.
	void createUser(String email, String password) throws Exception;

	// Retorna um booleano informando se a senha recebida está de acordo com as regras de negócio.
	boolean verifyPasswordRoles(String password);
}
