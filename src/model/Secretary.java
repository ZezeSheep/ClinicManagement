package model;

import controller.ViewController;
import model.enums.UserCategory;

public class Secretary extends User {

	public Secretary(String email, String passwordHash) {
		super(email, passwordHash, UserCategory.Secretary);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void showMenu(ViewController viewController) {
		viewController.getSecretaryScreen().setSecretary(this);
		viewController.getSecretaryScreen().show();
	}
    
}
