package Services;

import java.util.HashMap;

import Services.interfaces.ILoginService;
import model.Client;
import model.Constants;
import model.User;
import model.enums.UserCategory;
import repository.ClientRepository;
import repository.DentistRepository;
import repository.LoginRepository;
import repository.Repository;
import repository.SecretaryRepository;

public class LoginService implements ILoginService {
	
	private Repository<User> loginRepository;
	private HashMap<UserCategory, Repository> repositories;
	private final int MIN_PASSWORD_LENGTH = 8;

	public LoginService() {
		super();
		setupRespositories();
		this.loginRepository = new LoginRepository(Constants.LOGIN_DB_FILE_NAME);
	}

	public User login(String email, String password){
		User user = (User) loginRepository.get(email);
		if(user != null && isCorrectPassword(password, user.passwordHash)){
			return (User) repositories.get(user.userCategory).get(user.email);
		} else {
			return null;
		}
	}
	
	public void createUser(String email, String password) throws Exception {
		String hashPassword = SecurityService.getMD5Hash(password);
		// Regra de negócio: Todo usuário criado no processo de login é da categoria cliente.
		// Os demais usuários são criados através do menu do secretário.
		Client client = new Client(email, hashPassword);
		try {
			loginRepository.save((User) client);
			repositories.get(UserCategory.Client).save(client);
		} catch (Exception e) {
			System.err.println("Falha ao registrar o usuario " + client.email + " no banco de dados.");
			e.printStackTrace(System.err);
			throw e;
		}
	}
	
	public boolean verifyPasswordRoles(String password) {
		return password.length() >= MIN_PASSWORD_LENGTH;
	}
	
	private boolean isCorrectPassword(String inputedPassword, String hashSavedPassword) {
		return SecurityService.getMD5Hash(inputedPassword).equals(hashSavedPassword);
	}
	
	private void setupRespositories() {
		this.repositories = new HashMap<UserCategory, Repository>();
		this.repositories.put(UserCategory.Dentist, new DentistRepository(Constants.DENTIST_DB_FILE_NAME));
		this.repositories.put(UserCategory.Secretary, new SecretaryRepository(Constants.SECRETARY_DB_FILE_NAME));
		this.repositories.put(UserCategory.Client, new ClientRepository(Constants.CLIENT_DB_FILE_NAME));
	}
}
