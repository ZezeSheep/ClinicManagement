package Services;

import model.User;
import repository.LoginRepository;

public class LoginService {
	
	private LoginRepository _loginRepository;

	public boolean VerifyLogin(String email, String password) {
		User user = _loginRepository.get(email);
		return IsCorrectPassword(password, user.PasswordHash);
	}
	
	public void CreateUser(String email, String password) {
		String hashPassword = SecurityService.getMD5Hash(password);
		User user = new User(email, hashPassword);
		try {
			_loginRepository.save(user);
		} catch (Exception e) {
			System.err.print("Falha ao registrar o usuário " + user.Email + " no banco de dados");
		}
	}
	
	public void ChangePassword(String email, String password) {
		String hashPassword = SecurityService.getMD5Hash(password);
		try {
			User user = _loginRepository.get(email);
			user.setPasswordHash(hashPassword);
			_loginRepository.save(user);
		} catch (Exception e) {
			System.err.print("Falha ao modificar a senha do usuário " + email);
		}
	}
	
	private boolean IsCorrectPassword(String inputedPassword, String hashSavedPassword) {
		return SecurityService.getMD5Hash(inputedPassword).equals(hashSavedPassword);
	}
}
