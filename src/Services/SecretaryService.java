package Services;

import java.util.List;

import Services.interfaces.ISecretaryService;
import model.Constants;
import model.Dentist;
import model.Secretary;
import repository.SecretaryRepository;

public class SecretaryService implements ISecretaryService {
	private SecretaryRepository secretaryRepository;
	private LoginService loginService;
	
	public SecretaryService() {
		secretaryRepository = new SecretaryRepository(Constants.SECRETARY_DB_FILE_NAME);
		loginService = new LoginService();
	}
	
	public Secretary getSecretaryByEmail(String email) {
		return secretaryRepository.get(email);
	}
	
	public List<Secretary> getAllSecretaries(){
		return secretaryRepository.getAll();
	}
	
	public void createSecretary(Secretary secretary) {
		secretary.setPasswordHash(SecurityService.getMD5Hash(secretary.getPasswordHash()));
		loginService.createUser(secretary);
		secretaryRepository.save(secretary);
	}
}
