package controller;

import screen.ClientScreen;
import screen.DentistScreen;
import screen.LoginScreen;

public class ViewController {
	
	private ClientScreen _clientScreen;
	private DentistScreen _dentistScreen;
	private LoginScreen _loginScreen;
	
	public ViewController() {
		_clientScreen = new ClientScreen(this);
		_dentistScreen = new DentistScreen(this);
		_loginScreen = new LoginScreen(this);
	}

	public ClientScreen getClientScreen() {
		return _clientScreen;
	}
	
	public void start() {
		_loginScreen.show();
	}
	
	
	

}
