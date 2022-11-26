package model;

import controller.ViewController;
import model.enums.UserCategory;

public class Dentist extends User{

	public Dentist(String email, String passwordHash) {
		super(email, passwordHash, UserCategory.Dentist);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void showMenu(ViewController viewController) {
		viewController.getDentistScreen().setDentist(this);
		viewController.getDentistScreen().show();
	}
    
}
