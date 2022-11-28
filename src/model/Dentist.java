package model;

import java.util.List;

import controller.interfaces.IViewController;
import model.enums.UserCategory;

public class Dentist extends InternUser {
	
	protected List<Consult> consults;

	public Dentist(String email, String passwordHash) {
		super(email, passwordHash, UserCategory.Dentist);
	}
	
	public Dentist(String name, String email, String passwordHash, String cpf) {
		super(name, email, passwordHash, cpf);
		setUserCategory(UserCategory.Dentist);
	}

	@Override
	public void showMenu(IViewController viewController) {
		viewController.getDentistScreen().setDentist(this);
		viewController.getDentistScreen().show();
	}

	public List<Consult> getConsults() {
		return consults;
	}

	public void setConsults(List<Consult> consults) {
		this.consults = consults;
	}

}
