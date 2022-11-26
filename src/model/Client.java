package model;

import controller.interfaces.IViewController;
import model.enums.UserCategory;

public class Client extends User {

	public Client(String email, String passwordHash) {
		super(email, passwordHash, UserCategory.Client);
		// TODO Auto-generated constructor stub
	}

	public Client(String name, String email, String passwordHash, String cpf) {
		super(name, email, passwordHash, cpf);
		this.userCategory = UserCategory.Client;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showMenu(IViewController viewController) {
		viewController.getClientScreen().setClient(this);
		viewController.getClientScreen().show();
	}
    
}
