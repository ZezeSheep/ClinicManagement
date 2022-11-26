package screen;

import java.util.Scanner;

import controller.ViewController;
import model.Secretary;
import repository.SecretaryRepository;

public class SecretaryScreen extends Screen {
	
	private SecretaryRepository secretaryRepository;
	private Secretary secretary;

	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}

	public SecretaryScreen(ViewController viewController, Scanner scanner) {
		super(viewController, scanner);
		secretaryRepository = new SecretaryRepository("");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
