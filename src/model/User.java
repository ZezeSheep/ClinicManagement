package model;

public class User {
	public String Name;
	public String Email;
	public String PasswordHash;
	public String Cpf;
	
	public User(String email, String passwordHash) {
		Email = email;
		PasswordHash = passwordHash;
	}
	
	public User(String name, String email, String passwordHash, String cpf) {
		Name = name;
		Email = email;
		PasswordHash = passwordHash;
		Cpf = cpf;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPasswordHash() {
		return PasswordHash;
	}
	public void setPasswordHash(String passwordHash) {
		PasswordHash = passwordHash;
	}
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
}
