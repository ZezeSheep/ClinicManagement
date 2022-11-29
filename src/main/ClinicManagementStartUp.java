package main;

import Services.SecurityService;
import controller.ViewController;
import controller.interfaces.IViewController;
import model.Constants;
import model.Secretary;
import repository.LoginRepository;
import repository.SecretaryRepository;

public class ClinicManagementStartUp {

	public static void main(String[] args) {
		/*SecretaryRepository secretaryRepository = new SecretaryRepository(Constants.SECRETARY_DB_FILE_NAME);
		LoginRepository loginRepository = new LoginRepository(Constants.LOGIN_DB_FILE_NAME);
		Secretary s = new Secretary("Ziviani", "zizi@gmail.com", SecurityService.getMD5Hash("12345678"), "12345678912");
		loginRepository.save(s);*/
		IViewController viewController = new ViewController();
		viewController.start();
	}

}
