package model;

import controller.interfaces.IViewController;
import model.enums.UserCategory;

public class Secretary extends User {

	public Secretary(String email, String passwordHash) {
		super(email, passwordHash, UserCategory.Secretary);
	}
	
	public Secretary(String name, String email, String passwordHash, String cpf) {
		super(name, email, passwordHash, cpf);
		this.userCategory = UserCategory.Secretary;
	}

	@Override
	public void showMenu(IViewController viewController) {
		viewController.getSecretaryScreen().setSecretary(this);
		viewController.getSecretaryScreen().show();
	}
    
}
