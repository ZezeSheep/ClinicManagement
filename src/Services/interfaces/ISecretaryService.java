package Services.interfaces;

import java.util.List;

import model.Secretary;

public interface ISecretaryService {

	void createSecretary(Secretary secretary);

	List<Secretary> getAllSecretaries();

}
