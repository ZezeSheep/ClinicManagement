package model;

import controller.interfaces.IViewController;
import model.enums.UserCategory;

public class Dentist extends User{

	public Dentist(String email, String passwordHash) {
		super(email, passwordHash, UserCategory.Dentist);
	}
	
	public Dentist(String name, String email, String passwordHash, String cpf) {
		super(name, email, passwordHash, cpf);
		this.userCategory = UserCategory.Dentist;
	}

	@Override
	public void showMenu(IViewController viewController) {
		viewController.getDentistScreen().setDentist(this);
		viewController.getDentistScreen().show();
	}
    
}
