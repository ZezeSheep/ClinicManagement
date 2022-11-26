package model;

import java.io.Serializable;

import controller.interfaces.IViewController;
import model.enums.UserCategory;

public class User implements Serializable {
	public String name;
	public String email;
	public String passwordHash;
	public String cpf;
	public UserCategory userCategory;
	
	public User(String email, String passwordHash, UserCategory userCategory) {
		this.email = email;
		this.passwordHash = passwordHash;
		this.userCategory = userCategory;
	}
	
	public User(String name, String email, String passwordHash, String cpf) {
		this.name = name;
		this.email = email;
		this.passwordHash = passwordHash;
		this.cpf = cpf;
	}
	
	public void showMenu(IViewController viewController) {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public UserCategory getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	};
}
