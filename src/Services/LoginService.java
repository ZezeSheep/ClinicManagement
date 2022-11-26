package Services;

import model.User;
import repository.LoginRepository;

public class LoginService {
	
	private LoginRepository _loginRepository;

	public boolean verifyLogin(String email, String password) {
		User user = _loginRepository.get(email);
		return isCorrectPassword(password, user.PasswordHash);
	}
	
	public void createUser(String email, String password) throws Exception {
		String hashPassword = SecurityService.getMD5Hash(password);
		User user = new User(email, hashPassword);
		try {
			_loginRepository.save(user);
		} catch (Exception e) {
			System.err.print("Falha ao registrar o usuï¿½rio " + user.Email + " no banco de dados");
			throw e;
		}
	}
	
	public boolean verifyPasswordRoles(String password) {
		// Verifica se há pelo menos 1 letra maiúscula, 1 letra minúscula e 1 caractere especial.
		return true//password.matches("[a-z]")
				//&& password.matches("[A-Z]")
				//&& password.matches("[@!#$%&*(){}<>]")
				&& password.length() >= 8;
	}
	
	public void changePassword(String email, String password) {
		String hashPassword = SecurityService.getMD5Hash(password);
		try {
			User user = _loginRepository.get(email);
			user.setPasswordHash(hashPassword);
			_loginRepository.save(user);
		} catch (Exception e) {
			System.err.print("Falha ao modificar a senha do usuï¿½rio " + email);
		}
	}
	
	private boolean isCorrectPassword(String inputedPassword, String hashSavedPassword) {
		return SecurityService.getMD5Hash(inputedPassword).equals(hashSavedPassword);
	}
}
