package Services.interfaces;

import model.User;

public interface ILoginService {
	
	// Retorna o objeto User quando as credenciais estiverem corretas e null caso contr�rio.
	User login(String email, String password);

	// Retorna um booleano informando se a senha recebida est� de acordo com as regras de neg�cio.
	boolean verifyPasswordRoles(String password);

	void createUser(String userName, String userEmail, String userPassword)  throws Exception;
}
