package controller.interfaces;

import screen.ClientScreen;
import screen.DentistScreen;
import screen.LoginScreen;
import screen.SecretaryScreen;

public interface IViewController {

	// Inicia o sistema de telas e exibe a tela principal.
	void start();
	
	SecretaryScreen getSecretaryScreen();
	
	DentistScreen getDentistScreen();
	
	LoginScreen getLoginScreen();
	
	ClientScreen getClientScreen();
}
