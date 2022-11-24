package controller;

import screen.ClientScreen;

public class ViewController {
	
	private ClientScreen clientScreen;
	
	public ViewController() {
		clientScreen = new ClientScreen(this);
	}

	public ClientScreen getClientScreen() {
		return clientScreen;
	}

	public void setClientScreen(ClientScreen clientScreen) {
		this.clientScreen = clientScreen;
	}
	
	
	

}
