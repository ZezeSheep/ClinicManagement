package main;

import controller.ViewController;
import controller.interfaces.IViewController;

public class ClinicManagementStartUp {

	public static void main(String[] args) {
		IViewController viewController = new ViewController();
		viewController.start();
	}

}
