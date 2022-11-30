package model;

import model.enums.UserCategory;

public class InternUser extends User {
	private int registerNumber;
	
	public InternUser(String name, String email, String passwordHash, String cpf) {
		super(name, email, passwordHash, cpf);
	}
	
	public InternUser(String email, String passwordHash, UserCategory userCategory) {
		super(email, passwordHash, userCategory);
		this.email = email;
		this.passwordHash = passwordHash;
		this.userCategory = userCategory;
	}

	public int getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}
}
