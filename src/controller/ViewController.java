package controller;

import java.util.Scanner;

import screen.ClientScreen;
import screen.DentistScreen;
import screen.LoginScreen;
import screen.SecretaryScreen;

public class ViewController {
	
	private ClientScreen clientScreen;
	private DentistScreen dentistScreen;
	private LoginScreen loginScreen;
	private SecretaryScreen secretaryScreen;
	private Scanner scanner;
	
	public ViewController() {
		scanner = new Scanner(System.in);
		clientScreen = new ClientScreen(this, scanner);
		dentistScreen = new DentistScreen(this, scanner);
		loginScreen = new LoginScreen(this, scanner);
		secretaryScreen = new SecretaryScreen(this, scanner);
	}

	public SecretaryScreen getSecretaryScreen() {
		return secretaryScreen;
	}

	public DentistScreen getDentistScreen() {
		return dentistScreen;
	}

	public LoginScreen getLoginScreen() {
		return loginScreen;
	}

	public ClientScreen getClientScreen() {
		return clientScreen;
	}
	
	public void start() {
		loginScreen.show();
	}
	
	
	

}
