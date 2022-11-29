package controller;

import java.util.Scanner;

import controller.interfaces.IViewController;
import screen.ClientScreen;
import screen.DentistScreen;
import screen.LoginScreen;
import screen.SecretaryScreen;
import screen.interfaces.IScreen;

public class ViewController implements IViewController{
	
	private IScreen clientScreen;
	private IScreen dentistScreen;
	private IScreen loginScreen;
	private IScreen secretaryScreen;
	private Scanner scanner;
	
	public ViewController() {
		scanner = new Scanner(System.in);
		clientScreen = new ClientScreen(this, scanner);
		dentistScreen = new DentistScreen(this, scanner);
		loginScreen = new LoginScreen(this, scanner);
		secretaryScreen = new SecretaryScreen(this, scanner, null, null);
	}

	public SecretaryScreen getSecretaryScreen() {
		return (SecretaryScreen) secretaryScreen;
	}

	public DentistScreen getDentistScreen() {
		return (DentistScreen) dentistScreen;
	}

	public LoginScreen getLoginScreen() {
		return (LoginScreen) loginScreen;
	}

	public ClientScreen getClientScreen() {
		return (ClientScreen) clientScreen;
	}
	
	public void start() {
		loginScreen.show();
	}
	
	
	

}
