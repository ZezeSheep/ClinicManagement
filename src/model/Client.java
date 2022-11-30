package model;

import java.util.ArrayList;
import java.util.List;

import controller.interfaces.IViewController;
import model.enums.UserCategory;

public class Client extends User {
	
	protected int healthPlanRegister;
	protected List<Consult> consults;

	public Client(String email, String passwordHash) {
		super(email, passwordHash, UserCategory.Client);
		this.consults = new ArrayList<Consult>();
	}

	public Client(String name, String email, String passwordHash, String cpf) {
		super(name, email, passwordHash, cpf);
		this.consults = new ArrayList<Consult>();
		setUserCategory(UserCategory.Client);
	}

	@Override
	public void showMenu(IViewController viewController) {
		viewController.getClientScreen().setClient(this);
		viewController.getClientScreen().show();
	}
	
	public int getHealthPlanRegister() {
		return healthPlanRegister;
	}

	public void setHealthPlanRegister(int healthPlanRegister) {
		this.healthPlanRegister = healthPlanRegister;
	}

	public List<Consult> getConsults() {
		return consults;
	}

	public void setConsults(List<Consult> consults) {
		this.consults = consults;
	}
    
}
