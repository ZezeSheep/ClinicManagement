package Services;

import java.util.HashMap;

import model.Client;
import model.Constants;
import model.User;
import model.enums.UserCategory;
import repository.ClientRepository;
import repository.DentistRepository;
import repository.LoginRepository;
import repository.Repository;
import repository.SecretaryRepository;

public class LoginService {
	
	private LoginRepository loginRepository;
	private HashMap<UserCategory, Repository> repositories;
	

	public LoginService() {
		super();
		setupRespositories();
		this.loginRepository = new LoginRepository(Constants.LOGIN_DB_FILE_NAME);
	}
	
	private void setupRespositories() {
		repositories.put(UserCategory.Dentist, new DentistRepository(Constants.DENTIST_DB_FILE_NAME));
		repositories.put(UserCategory.Secretary, new SecretaryRepository(Constants.SECRETARY_DB_FILE_NAME));
		repositories.put(UserCategory.Client, new ClientRepository(Constants.CLIENT_DB_FILE_NAME));
	}

	public User login(String email, String password){
		User user = loginRepository.get(email);
		if(user != null && isCorrectPassword(password, user.passwordHash)){
			return (User) repositories.get(user.userCategory).get(user.email);
		} else {
			return null;
		}
	}
	
	public void createUser(String email, String password) throws Exception {
		String hashPassword = SecurityService.getMD5Hash(password);
		System.out.println("hashPassword: " + hashPassword);
		// Regra de negócio: Todo usuário criado no processo de login é da categoria cliente.
		// Os demais usuários são criados através do menu do secretário.
		Client client = new Client(email, hashPassword);
		try {
			loginRepository.save((User) client);
			repositories.get(UserCategory.Client).save(client);
		} catch (Exception e) {
			System.err.println("Falha ao registrar o usuario " + client.email + " no banco de dados");
			e.printStackTrace(System.err);
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
			User user = loginRepository.get(email);
			user.setPasswordHash(hashPassword);
			loginRepository.save(user);
		} catch (Exception e) {
			System.err.print("Falha ao modificar a senha do usuario " + email);
		}
	}
	
	private boolean isCorrectPassword(String inputedPassword, String hashSavedPassword) {
		System.out.println("Senha digitada: " + SecurityService.getMD5Hash(inputedPassword));
		System.out.println("Senha correta: " + hashSavedPassword);
		return SecurityService.getMD5Hash(inputedPassword).equals(hashSavedPassword);
	}
}
